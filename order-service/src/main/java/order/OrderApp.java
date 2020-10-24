package order;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableFeignClients
//@RibbonClient(name = "payment-service",configuration = RandomRule.class)
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class);
    }
    @Bean
    @LoadBalanced
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
