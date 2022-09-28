package service;

import org.example.grpc.Multi;
import org.example.grpc.multiplyGrpc;
import io.grpc.stub.StreamObserver;

public class multiServer extends multiplyGrpc.multiplyImplBase {
    @Override
    public void sayHello(Multi.HelloRequest request, io.grpc.stub.StreamObserver<Multi.HelloReply> responseObserver) {
        String name = request.getName();

        Multi.HelloReply.Builder response = Multi.HelloReply.newBuilder();
        response.setMessage("Hello " + name);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void askMulti(Multi.NumRequest request, io.grpc.stub.StreamObserver<Multi.NumReply> responseObserver) {
        int num1 = request.getNum1();
        int num2 = request.getNum2();

        int answer = num1 * num2;
        String str_answer = Integer.toString(answer);

        Multi.NumReply.Builder response = Multi.NumReply.newBuilder();
        response.setAnswer("The mulptiplication of the two numbers is" + str_answer);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}

