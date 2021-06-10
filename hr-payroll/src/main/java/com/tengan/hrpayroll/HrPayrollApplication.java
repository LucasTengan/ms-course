package com.tengan.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient // eureka faz o load balancing naturalmente
public class HrPayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrPayrollApplication.class, args);
    }

}
