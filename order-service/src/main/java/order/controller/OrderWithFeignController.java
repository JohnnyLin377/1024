package order.controller;

import commons.pojo.Payment;
import commons.vo.CommonResult;
import order.service.PaymentService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderWithFeignController {
    @Resource
    private PaymentService paymentService;
    @GetMapping("/feign/orders/{oid}")
    public CommonResult<Payment> loadOrder(@PathVariable("oid") int oid){
       Payment payment= paymentService.loadPayment(oid);
       return new CommonResult<Payment>(203,"succ",payment);
    }
    @GetMapping("/feign/orders")
    public CommonResult<List<Payment>> loadPaymentsByOrder(){
        List<Payment> payments=paymentService.findAllPayments();
        return new CommonResult(206,"succss!",payments);
    }
}
