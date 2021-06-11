package com.tengan.hrpayroll.adapter.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tengan.hrpayroll.application.services.PaymentService;
import com.tengan.hrpayroll.domain.entities.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(workerId, days);

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
        Payment payment = new Payment("Brann", 400.0, days);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
