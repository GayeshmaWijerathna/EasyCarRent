package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String> {
    @Query(value = "select * from User where userName=? AND password=? limit 1",nativeQuery = true)
    User findUserByUserNameAndPassword(String username, String password) throws RuntimeException;
}
