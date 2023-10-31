package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.dto.RegUserDTO;
import lk.ijse.easycarrent.entity.Reg_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Reg_UserRepo extends JpaRepository<Reg_User, String> {
    @Query(value = "SELECT userId FROM Reg_User ORDER BY userId DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(userId) FROM Reg_User", nativeQuery = true)
    int getSumUsers();

    @Query(value = "SELECT reg_user.userId,reg_user.firstName,reg_user.lastName,reg_user.contactNo,reg_user.address,reg_user.email,reg_user.nic,reg_user.licenseNo,reg_user.nicImg,reg_user.licenseImg FROM Reg_User JOIN  user u on u.userId = reg_user.userId where userName=?1", nativeQuery = true)
    RegUserDTO availableUser(String userName);
}
