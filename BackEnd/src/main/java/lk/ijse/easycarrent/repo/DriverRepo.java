package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, String> {
}
