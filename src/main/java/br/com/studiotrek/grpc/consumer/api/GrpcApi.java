package br.com.studiotrek.grpc.consumer.api;

import br.com.studiotrek.grpc.consumer.service.SendGreeterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcApi {

    @Autowired
    private SendGreeterImpl grpcClientService;

    @RequestMapping("/{name}")
    public String printMessage(@RequestParam(defaultValue = "Ronaldo") String name) {
        return grpcClientService.sendMessage(name);
    }

}
