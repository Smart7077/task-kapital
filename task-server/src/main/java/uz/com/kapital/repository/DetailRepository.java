package uz.com.kapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.kapital.entity.Detail;

public interface DetailRepository extends JpaRepository<Detail, Integer> {
    Detail findByOrderId(Integer id);
}
