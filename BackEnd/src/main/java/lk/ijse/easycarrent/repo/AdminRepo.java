package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, String> {
}
