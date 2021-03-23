package uz.com.kapital.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.com.kapital.entity.Category;

@Projection(name = "customCategory", types = Category.class)
public interface CustomCategory {
    Integer getId();

    String getName();
}
