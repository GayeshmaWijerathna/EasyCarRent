package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepo extends JpaRepository<Rent,String> {
}