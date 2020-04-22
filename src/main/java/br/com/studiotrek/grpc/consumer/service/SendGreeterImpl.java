package br.com.studiotrek.grpc.consumer.service;

import br.com.studiotrek.proto.GreeterGrpc;
import br.com.studiotrek.proto.HelloReply;
import br.com.studiotrek.proto.HelloRequest;
import io.grpc.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;


@Service
public class SendGreeterImpl {

    @GrpcClient("local-grpc-server")
    private GreeterGrpc.GreeterBlockingStub stub;

    public String sendMessage(final String name) {
        try {
            final HelloReply response = this.stub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getReply();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }

}
