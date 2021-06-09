package com.tengan.hrpayroll.adapter.feignclients;

import com.tengan.hrpayroll.domain.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {        // Representa os métodos daquele microsserviço naquele endpoint, é meio que um "mock"

    @GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
