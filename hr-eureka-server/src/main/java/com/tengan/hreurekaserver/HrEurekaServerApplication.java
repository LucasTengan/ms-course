package com.tengan.hreurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer         // Eureka serve pra fazer o controle/registro dos microsserviços, gerar portas aleatórias e chamar os microsserviços pelo nome, não endereço/localização
public class HrEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrEurekaServerApplication.class, args);
    }

}
