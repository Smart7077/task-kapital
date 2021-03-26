package uz.com.kapital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.com.kapital.payload.ApiResponse;
import uz.com.kapital.payload.ReqOrderDetail;
import uz.com.kapital.repository.OrderRepository;
import uz.com.kapital.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order/details/{order_id}")
    public HttpEntity<?> getOrderList(@PathVariable Integer order_id) {

        return ResponseEntity.ok(orderService.getOrderById(order_id));
    }

    @GetMapping("/orders_without_details")
    public HttpEntity<?> getOrder() {
        return ResponseEntity.ok(orderService.getOrderWithoutDetil());
    }

    @PostMapping("/order")
    public HttpEntity<?> addOrder(@RequestBody ReqOrderDetail reqOrderDetail) {
        ApiResponse response = orderService.addOrder(reqOrderDetail);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/number_of_products_in_year")
    public HttpEntity<?> getTotalNumber() {
        return ResponseEntity.ok(orderRepository.getTotalOrderInYear());
    }

    @GetMapping("/orders_without_invoices")
    public HttpEntity<?> getOrdersWithoutInvoice() {
        return ResponseEntity.ok(orderRepository.getOrderWithoutInvoice());
    }

}
