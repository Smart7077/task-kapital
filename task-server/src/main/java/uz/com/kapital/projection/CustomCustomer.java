package uz.com.kapital.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.com.kapital.entity.Customer;

@Projection(name = "customCustomer", types = Customer.class)
public interface CustomCustomer {
    Integer getId();

    String getName();

    String getCountry();

    String getAddress();

    String getPhone();
}
