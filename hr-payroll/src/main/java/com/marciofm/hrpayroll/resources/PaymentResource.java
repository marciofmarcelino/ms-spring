package com.marciofm.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marciofm.hrpayroll.entities.Payment;
import com.marciofm.hrpayroll.services.PaymentService;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	private static final String PAYMENTS_SERVICE = "payments";
	
	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	@CircuitBreaker(name = PAYMENTS_SERVICE, fallbackMethod = "getPaymentAlternative")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok().body(payment);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative( Long workerId, Integer days, FeignException e){
		Payment payment = new Payment("Bob", 200.0,20);
		return ResponseEntity.ok().body(payment);
	}
}
