from concurrent import futures
import time
import logging
import grpc
import multi_pb2
import multi_pb2_grpc

class multiplyServicer(multi_pb2_grpc.multiplyServicer):
    def sayHello(self, request, context):
        print("SayHello Request Made: ")
        return multi_pb2.HelloReply(message='Hello, %s!' % request.name)

    def askMulti(self, request, context):
        print("AskMulti Request Made: ")
        result = str(request.num1 * request.num2)
        Reply = multi_pb2.NumReply()
        Reply.answer = 'The multiplied value is %s' % result

        return Reply

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    multi_pb2_grpc.add_multiplyServicer_to_server(multiplyServicer(), server)
    server.add_insecure_port('localhost:50051')
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    logging.basicConfig()
    serve()