import multi_pb2
import multi_pb2_grpc
import time
import logging

import grpc

def run():
    with grpc.insecure_channel('localhost:50051') as channel:
        stub = multi_pb2_grpc.multiplyStub(channel)
        response = stub.sayHello(multi_pb2.HelloRequest(name="Scarlett"))
        print("Greeter client received: " + response.message)
        response = stub.askMulti(multi_pb2.NumRequest(num1=3, num2=2))
        print("Greeter client received: " + response.answer)


if __name__ == '__main__':
    logging.basicConfig()
    run()