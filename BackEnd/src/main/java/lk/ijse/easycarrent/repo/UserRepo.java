package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
