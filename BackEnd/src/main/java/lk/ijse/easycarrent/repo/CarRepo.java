package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, String> {
}
