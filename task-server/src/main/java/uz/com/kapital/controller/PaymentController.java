package uz.com.kapital.controller;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.com.kapital.entity.Payment;
import uz.com.kapital.payload.ApiResponse;
import uz.com.kapital.repository.PaymentRepository;
import uz.com.kapital.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    final
    PaymentRepository paymentRepository;
    final
    PaymentService paymentService;

    public PaymentController(PaymentRepository paymentRepository, PaymentService paymentService) {
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
    }

    @PostMapping
    public HttpEntity<?> addPayment(@RequestParam Integer invoice_id) {
        ApiResponse response = paymentService.add(invoice_id);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/details/{id}")
    public HttpEntity<?> getPayment(@PathVariable Integer id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("GetPAYMENT"));
        return ResponseEntity.ok(paymentService.getPayment(payment));
    }


}

