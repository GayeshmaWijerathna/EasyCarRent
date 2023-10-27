package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, String> {
}
