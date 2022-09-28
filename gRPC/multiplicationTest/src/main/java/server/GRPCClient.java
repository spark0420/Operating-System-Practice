package server;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.example.grpc.multiplyGrpc;
import org.example.grpc.Multi;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GRPCClient {
    private static final Logger logger = Logger.getLogger(GRPCClient.class.getName());

    private final multiplyGrpc.multiplyBlockingStub blockingStub;

    /** Construct client for accessing HelloWorld server using the existing channel. */
    public GRPCClient(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = multiplyGrpc.newBlockingStub(channel);
    }
    public void multiply(String name, int num1, int num2) {
        logger.info("Will try to greet " + name + " ...");
        Multi.HelloRequest request = Multi.HelloRequest.newBuilder().setName(name).build();
        Multi.HelloReply response;
        Multi.NumRequest request2 = Multi.NumRequest.newBuilder().setNum1(num1).setNum2(num2).build();
        Multi.NumReply response2;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: " + response.getMessage());
        try {
            response2 = blockingStub.askMulti(request2);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: " + response2.getAnswer());
    }
    public static void main(String[] args) throws Exception {
        String user = "Scarlett";
        int num1 = 5;
        int num2 = 2;
        // Access a service running on the local machine on port 50051
        String target = "localhost:50051";
        // Allow passing in the user and target strings as command line arguments
        if (args.length > 0) {
            if ("--help".equals(args[0])) {
                System.err.println("Usage: [name [target]]");
                System.err.println("");
                System.err.println("  name    The name you wish to be greeted by. Defaults to " + user);
                System.err.println("  target  The server to connect to. Defaults to " + target);
                System.exit(1);
            }
            user = args[0];
        }
        if (args.length > 1) {
            target = args[1];
        }

        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        try {
            GRPCClient client = new GRPCClient(channel);
            client.multiply(user, num1, num2);
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}

