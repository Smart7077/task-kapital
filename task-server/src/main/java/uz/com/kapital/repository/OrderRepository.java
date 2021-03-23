package uz.com.kapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.com.kapital.entity.Order;
import uz.com.kapital.projection.ResNumberOfYear;
import uz.com.kapital.projection.ResOrderWithoutInvoice;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT o.id,o.date,o.cust_id FROM orders o" +
            " LEFT JOIN detail ON o.id = detail.ord_id where o.date<'2016-09-06'" +
            "EXCEPT SELECT o.id,o.date,o.cust_id FROM orders o RIGHT JOIN detail ON o.ID = detail.ord_id " +
            "where o.date<'2016-09-06'\n", nativeQuery = true)
    List<Order> getOrdersWithOutDetail();

    @Query(value = "select Count(o.cust_id) totalOrder,c.country from orders o,customer c where o.cust_id=c.id and date_part('Year',o.date)=2016 GROUP BY(c.country)", nativeQuery = true)
    List<ResNumberOfYear> getTotalOrderInYear();

    @Query(value = "SELECT o.id,o.date,Sum(p.price) as totalPrice FROM detail d,product p,orders o LEFT JOIN invoice i ON o.id = i.ord_id WHERE i.ord_id IS NULL and  o.id=d.ord_id and d.pr_id=p.id group by(o.id,o.date)", nativeQuery = true)
    List<ResOrderWithoutInvoice> getOrderWithoutInvoice();


}
