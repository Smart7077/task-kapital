package uz.com.kapital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.com.kapital.repository.ProductRepository;
import uz.com.kapital.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping("/product/list")
    public HttpEntity<?> getProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/product/details/{product_id}")
    public HttpEntity<?> getProducts(@PathVariable Integer product_id) {
        return ResponseEntity.ok(productRepository.findById(product_id).orElseThrow(() -> new ResourceNotFoundException("getProduct")));
    }

    @GetMapping("/high_demand_products")
    public HttpEntity<?> getHighDemandProducts() {
        return ResponseEntity.ok(productRepository.getHighDemandProduct());
    }

    @GetMapping("/bulk_products")
    public HttpEntity<?> getBulkProducts() {
        return ResponseEntity.ok(productRepository.getBulkProduct());
    }
}
