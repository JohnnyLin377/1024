package payment.controller;

import commons.pojo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    int port;
    @GetMapping("/payments/{id}")
    public Payment loadPayment(@PathVariable("id") int id){
        String sn="pay"+ UUID.randomUUID().toString().substring(23)+",port:"+port;
        return new Payment(id,sn);
    }
}
