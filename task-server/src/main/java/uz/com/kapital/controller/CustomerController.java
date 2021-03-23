package uz.com.kapital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.com.kapital.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers_without_orders")
    public HttpEntity<?> getWithoutOrders() {
        return ResponseEntity.ok(customerService.getCustomerWithoutOrder());
    }

    @GetMapping("/customers_last_orders")
    public HttpEntity<?> getCustomerLastOrderYear() {
        return ResponseEntity.ok(customerService.getCustomerLastOrder());
    }

    @GetMapping("/test")
    public HttpEntity<?> getTest() {
        return ResponseEntity.ok(customerService.getTest());
    }
}
