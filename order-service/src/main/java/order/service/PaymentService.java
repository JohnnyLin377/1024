package order.service;

import commons.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "payment-service")
@Service
public interface PaymentService {
    @GetMapping("/payments/{id}")
    Payment loadPayment(@PathVariable("id") int id);
    @GetMapping("/payments")
    List<Payment> findAllPayments();
}
