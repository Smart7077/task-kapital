package uz.com.kapital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.com.kapital.entity.Customer;
import uz.com.kapital.payload.ApiResponse;
import uz.com.kapital.payload.ResCustomer;
import uz.com.kapital.payload.ResCustomerLast;
import uz.com.kapital.projection.ResCustomerByOrder;
import uz.com.kapital.repository.CustomerRepository;
import uz.com.kapital.repository.OrderRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    public List<ResCustomer> getCustomerWithoutOrder() {
        List<Customer> customerList = customerRepository.getCustomers();
        return customerList.stream().map(this::getCustomer).collect(Collectors.toList());
    }

    public ResCustomer getCustomer(Customer customer) {
        return new ResCustomer(
                customer.getId(),
                customer.getName(),
                customer.getCountry(),
                customer.getAddress(),
                customer.getPhone()
        );
    }

    public List<ResCustomerLast> getCustomerLastOrder() {
        List<Customer> customerList = customerRepository.getCustomerLastOrderYear();
        return customerList.stream().map(this::getCustomerLast).collect(Collectors.toList());

    }

    public ResCustomerLast getCustomerLast(Customer customer) {
        return new ResCustomerLast(
                customer.getId(),
                customer.getName()
        );
    }


    public ApiResponse getTest() {
        List<ResCustomerByOrder> resCustomerList = customerRepository.getAllByAddressAfterAnd();
        return new ApiResponse(
                "GET",
                true, resCustomerList.stream().map(this::getCustomerLastOrder).collect(Collectors.toList())
        );
    }


    public ResCustomerByOrder getCustomerLastOrder(ResCustomerByOrder resCustomerByOrder) {
        return new ResCustomerByOrder() {
            @Override
            public Integer getId() {
                return resCustomerByOrder.getId();
            }

            @Override
            public String getName() {
                return resCustomerByOrder.getName();
            }

            @Override
            public Date getLastOrderDate() {
                return resCustomerByOrder.getLastOrderDate();
            }


        };
    }
}
