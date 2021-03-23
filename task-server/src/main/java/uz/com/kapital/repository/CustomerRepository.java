package uz.com.kapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.com.kapital.entity.Customer;
import uz.com.kapital.projection.ResCustomerByOrder;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select c.id,c.name,c.address,c.country,c.phone from customer c,orders o where c.id=o.cust_id and (select date_part('year', o.date))!=2016", nativeQuery = true)
    List<Customer> getCustomers();

    @Query(value = "select c.id,c.name,c.address,c.country,c.phone,max(o.date) from customer c,orders o where c.id=o.cust_id group by(c.id)", nativeQuery = true)
    List<Customer> getCustomerLastOrderYear();

//    List<Customer> f();


    @Query(value = "select c.id,c.name,max(o.date) as lastOrderDate from customer c,orders o where c.id=o.cust_id group by(c.id)", nativeQuery = true)
    List<ResCustomerByOrder> getAllByAddressAfterAnd();

}
