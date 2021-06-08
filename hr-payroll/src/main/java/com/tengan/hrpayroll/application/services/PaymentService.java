package com.tengan.hrpayroll.application.services;

import com.tengan.hrpayroll.adapter.feignclients.WorkerFeignClient;
import com.tengan.hrpayroll.domain.entities.Payment;
import com.tengan.hrpayroll.domain.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
