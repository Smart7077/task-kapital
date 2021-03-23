package uz.com.kapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.kapital.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
