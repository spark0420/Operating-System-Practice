package service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import org.example.grpc.GreeterGrpc;
import org.example.grpc.Greeting;

public class GreetingServer extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(Greeting.HelloRequest request, io.grpc.stub.StreamObserver<Greeting.HelloReply> responseObserver) {
        String name = request.getName();

        Greeting.HelloReply.Builder response = Greeting.HelloReply.newBuilder();
        response.setMessage("Hello " + name);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloAgain(Greeting.HelloRequest request, io.grpc.stub.StreamObserver<Greeting.HelloReply> responseObserver) {
        String name = request.getName();

        Greeting.HelloReply.Builder response = Greeting.HelloReply.newBuilder();
        response.setMessage("Hello Again" + request.getName());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
