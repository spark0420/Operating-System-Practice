package org.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: multi.proto")
public final class multiplyGrpc {

  private multiplyGrpc() {}

  public static final String SERVICE_NAME = "multiply";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.grpc.Multi.HelloRequest,
      org.example.grpc.Multi.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHello",
      requestType = org.example.grpc.Multi.HelloRequest.class,
      responseType = org.example.grpc.Multi.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.grpc.Multi.HelloRequest,
      org.example.grpc.Multi.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<org.example.grpc.Multi.HelloRequest, org.example.grpc.Multi.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = multiplyGrpc.getSayHelloMethod) == null) {
      synchronized (multiplyGrpc.class) {
        if ((getSayHelloMethod = multiplyGrpc.getSayHelloMethod) == null) {
          multiplyGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<org.example.grpc.Multi.HelloRequest, org.example.grpc.Multi.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "multiply", "sayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Multi.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Multi.HelloReply.getDefaultInstance()))
                  .setSchemaDescriptor(new multiplyMethodDescriptorSupplier("sayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.grpc.Multi.NumRequest,
      org.example.grpc.Multi.NumReply> getAskMultiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "askMulti",
      requestType = org.example.grpc.Multi.NumRequest.class,
      responseType = org.example.grpc.Multi.NumReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.grpc.Multi.NumRequest,
      org.example.grpc.Multi.NumReply> getAskMultiMethod() {
    io.grpc.MethodDescriptor<org.example.grpc.Multi.NumRequest, org.example.grpc.Multi.NumReply> getAskMultiMethod;
    if ((getAskMultiMethod = multiplyGrpc.getAskMultiMethod) == null) {
      synchronized (multiplyGrpc.class) {
        if ((getAskMultiMethod = multiplyGrpc.getAskMultiMethod) == null) {
          multiplyGrpc.getAskMultiMethod = getAskMultiMethod = 
              io.grpc.MethodDescriptor.<org.example.grpc.Multi.NumRequest, org.example.grpc.Multi.NumReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "multiply", "askMulti"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Multi.NumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Multi.NumReply.getDefaultInstance()))
                  .setSchemaDescriptor(new multiplyMethodDescriptorSupplier("askMulti"))
                  .build();
          }
        }
     }
     return getAskMultiMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static multiplyStub newStub(io.grpc.Channel channel) {
    return new multiplyStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static multiplyBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new multiplyBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static multiplyFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new multiplyFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class multiplyImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(org.example.grpc.Multi.HelloRequest request,
        io.grpc.stub.StreamObserver<org.example.grpc.Multi.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void askMulti(org.example.grpc.Multi.NumRequest request,
        io.grpc.stub.StreamObserver<org.example.grpc.Multi.NumReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAskMultiMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.grpc.Multi.HelloRequest,
                org.example.grpc.Multi.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getAskMultiMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.grpc.Multi.NumRequest,
                org.example.grpc.Multi.NumReply>(
                  this, METHODID_ASK_MULTI)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class multiplyStub extends io.grpc.stub.AbstractStub<multiplyStub> {
    private multiplyStub(io.grpc.Channel channel) {
      super(channel);
    }

    private multiplyStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected multiplyStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new multiplyStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(org.example.grpc.Multi.HelloRequest request,
        io.grpc.stub.StreamObserver<org.example.grpc.Multi.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void askMulti(org.example.grpc.Multi.NumRequest request,
        io.grpc.stub.StreamObserver<org.example.grpc.Multi.NumReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAskMultiMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class multiplyBlockingStub extends io.grpc.stub.AbstractStub<multiplyBlockingStub> {
    private multiplyBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private multiplyBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected multiplyBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new multiplyBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public org.example.grpc.Multi.HelloReply sayHello(org.example.grpc.Multi.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.grpc.Multi.NumReply askMulti(org.example.grpc.Multi.NumRequest request) {
      return blockingUnaryCall(
          getChannel(), getAskMultiMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class multiplyFutureStub extends io.grpc.stub.AbstractStub<multiplyFutureStub> {
    private multiplyFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private multiplyFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected multiplyFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new multiplyFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.grpc.Multi.HelloReply> sayHello(
        org.example.grpc.Multi.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.grpc.Multi.NumReply> askMulti(
        org.example.grpc.Multi.NumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAskMultiMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_ASK_MULTI = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final multiplyImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(multiplyImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((org.example.grpc.Multi.HelloRequest) request,
              (io.grpc.stub.StreamObserver<org.example.grpc.Multi.HelloReply>) responseObserver);
          break;
        case METHODID_ASK_MULTI:
          serviceImpl.askMulti((org.example.grpc.Multi.NumRequest) request,
              (io.grpc.stub.StreamObserver<org.example.grpc.Multi.NumReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class multiplyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    multiplyBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.grpc.Multi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("multiply");
    }
  }

  private static final class multiplyFileDescriptorSupplier
      extends multiplyBaseDescriptorSupplier {
    multiplyFileDescriptorSupplier() {}
  }

  private static final class multiplyMethodDescriptorSupplier
      extends multiplyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    multiplyMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (multiplyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new multiplyFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getAskMultiMethod())
              .build();
        }
      }
    }
    return result;
  }
}
