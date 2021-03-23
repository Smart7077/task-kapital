package uz.com.kapital.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.com.kapital.entity.Customer;
import uz.com.kapital.entity.Order;

import java.util.Date;

@Projection(name = "customOrder", types = Order.class)
public interface CustomOrder {
    Integer getId();

    Date getDate();

    Customer getCustomer();
}
