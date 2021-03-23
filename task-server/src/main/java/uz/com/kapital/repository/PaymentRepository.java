package uz.com.kapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.kapital.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
