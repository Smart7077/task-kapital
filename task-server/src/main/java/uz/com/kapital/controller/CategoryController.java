package uz.com.kapital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.com.kapital.entity.Category;
import uz.com.kapital.entity.Product;
import uz.com.kapital.repository.CategoryRepository;
import uz.com.kapital.repository.ProductRepository;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/category/list")
    public HttpEntity<?> getCategoryList() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping("/category/{product_id}")
    public HttpEntity<?> getCategoryById(@PathVariable Integer product_id) {
        Product product = productRepository.findById(product_id).orElseThrow(() -> new ResourceNotFoundException("getProduct"));
        Category category = categoryRepository.getOne(product.getCategory().getId());
        return ResponseEntity.ok(category);
    }
}
