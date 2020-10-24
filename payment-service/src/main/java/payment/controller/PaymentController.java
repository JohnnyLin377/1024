package payment.controller;

import commons.pojo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
    @GetMapping("/payments")
    public List<Payment> findAllPayments(){
        List<Payment> payments=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
           String sn="pay"+ UUID.randomUUID().toString().substring(23)+",port:"+port;
            Payment p=new Payment(i+1,sn);
            payments.add(p);
        }
        return payments;
    }

}
