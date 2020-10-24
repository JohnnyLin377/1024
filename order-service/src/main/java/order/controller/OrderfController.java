package order.controller;

import commons.pojo.Payment;
import commons.vo.CommonResult;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderfController {
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/orders/{oid}")
    public CommonResult<Payment> loadOrder(@PathVariable("oid") int oid){
//        String url="http://127.0.0.1:3000/payments/{id}";
        String url="http://payment-service/payments/{id}";
       Payment payment= restTemplate
               .getForObject(url,Payment.class,oid);
//       ResponseEntity<Payment> responseEntity= restTemplate.getForEntity(url,Payment.class);
//       responseEntity.getStatusCode();
//       responseEntity.getBody()
        return  new CommonResult<Payment>(203,"通过订单查询支付信息",payment);
    }
    @GetMapping("/orders")
    public CommonResult<List<Payment>> loadPaymentsByOrder(){
        ParameterizedTypeReference<List<Payment>> reference=new ParameterizedTypeReference<List<Payment>>() {};
        String url="http://payment-service/payments";
        ResponseEntity<List<Payment>> entity= restTemplate.exchange(url, HttpMethod.GET,null,reference);
        List<Payment> payments=entity.getBody();
        return new CommonResult(206,"succss!",payments);
    }

}
