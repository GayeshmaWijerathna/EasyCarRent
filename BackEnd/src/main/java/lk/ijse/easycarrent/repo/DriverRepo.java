package lk.ijse.easycarrent.repo;

import lk.ijse.easycarrent.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver, String> {
    @Query(value = "SELECT userId FROM Driver ORDER BY userId DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(userId) FROM Driver", nativeQuery = true)
    int getSumDriver();

    @Query(value = "SELECT COUNT(userId) FROM Driver WHERE driverAvailability='AVAILABLE'", nativeQuery = true)
    int getSumAvailableDriver();

    @Query(value = "SELECT COUNT(userId) FROM Driver WHERE driverAvailability='UNAVAILABLE'", nativeQuery = true)
    int getSumUnavailableDriver();

    @Query(value = "SELECT * FROM Driver WHERE driverAvailability='AVAILABLE'", nativeQuery = true)
    List<Driver> availableDrivers();
}

