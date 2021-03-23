package uz.com.kapital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.com.kapital.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


}
