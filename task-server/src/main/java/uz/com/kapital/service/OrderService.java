package uz.com.kapital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.com.kapital.entity.Detail;
import uz.com.kapital.entity.Order;
import uz.com.kapital.entity.Product;
import uz.com.kapital.payload.ApiResponse;
import uz.com.kapital.payload.ReqOrderDetail;
import uz.com.kapital.payload.ResOrder;
import uz.com.kapital.payload.ResOrderProduct;
import uz.com.kapital.repository.CustomerRepository;
import uz.com.kapital.repository.DetailRepository;
import uz.com.kapital.repository.OrderRepository;
import uz.com.kapital.repository.ProductRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DetailRepository detailRepository;
    @Autowired
    ProductRepository productRepository;

    public List<ResOrder> getOrderWithoutDetil() {
        List<Order> orderList = orderRepository.getOrdersWithOutDetail();
        return orderList.stream().map(this::getOrder).collect(Collectors.toList());
    }

    public ResOrder getOrder(Order order) {
        return new ResOrder(
                order.getId(),
                order.getDate(),
                order.getCustomer().getId()
        );
    }

    public ApiResponse addOrder(ReqOrderDetail reqOrderDetail) {
        try {
            Order order = new Order();
            order.setDate(new Date());
            order.setCustomer(customerRepository.getOne(reqOrderDetail.getCustomer_id()));
            Order savedOrder = orderRepository.save(order);
            Detail detail = new Detail();
            detail.setOrder(orderRepository.getOne(savedOrder.getId()));
            detail.setProduct(productRepository.getOne(reqOrderDetail.getProduct_id()));
            detail.setQuantity(reqOrderDetail.getQuantity());
            Detail savedDetail = detailRepository.save(detail);
            return new ApiResponse("SUCCESS", true, savedDetail.getId());
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);
        }
    }

    public ResOrderProduct getOrderById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getOrder"));
        Detail detail = detailRepository.findByOrderId(order.getId());
        Product product = productRepository.findById(detail.getProduct().getId()).orElseThrow(() -> new ResourceNotFoundException("getProduct"));

        return new ResOrderProduct(
                order.getId(),
                order.getDate(),
                order.getCustomer().getId(),
                product.getName()
        );
    }
}
