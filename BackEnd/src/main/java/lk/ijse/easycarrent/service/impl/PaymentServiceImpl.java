package lk.ijse.easycarrent.service.impl;

import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.dto.PaymentDTO;
import lk.ijse.easycarrent.entity.Car;
import lk.ijse.easycarrent.entity.Driver;
import lk.ijse.easycarrent.entity.Payment;
import lk.ijse.easycarrent.entity.Rent;
import lk.ijse.easycarrent.repo.CarRepo;
import lk.ijse.easycarrent.repo.DriverRepo;
import lk.ijse.easycarrent.repo.PaymentRepo;
import lk.ijse.easycarrent.repo.RentRepo;
import lk.ijse.easycarrent.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import static lk.ijse.easycarrent.enums.AvailabilityType.AVAILABLE;
import static lk.ijse.easycarrent.enums.AvailabilityType.UNDER_MAINTAIN;
import static lk.ijse.easycarrent.enums.RentRequestType.PAY;


@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private RentRepo rentRepo;
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public CustomDTO paymentIdGenerate() {
        return new CustomDTO(paymentRepo.getLastIndex());
    }

    @Override
    public void savePayment(PaymentDTO dto, String rentID) {
        Payment payment = mapper.map(dto, Payment.class);
        Rent rent = rentRepo.findById(rentID).get();
        if (rent.getRentDetails().get(0).getDriverID() != null) {

            Driver drivers = driverRepo.findById(rent.getRentDetails().get(0).getDriverID()).get();
            drivers.setDriverAvailability(AVAILABLE);
            driverRepo.save(drivers);

            Car car = carRepo.findById(rent.getRentDetails().get(0).getCarID()).get();
            car.setVehicleAvailabilityType(UNDER_MAINTAIN);
            carRepo.save(car);

            rent.setRentType(PAY);
            rentRepo.save(rent);
        }
        if (rent.getRentDetails().get(0).getDriverID() == null) {
            Car car = carRepo.findById(rent.getRentDetails().get(0).getCarID()).get();
            car.setVehicleAvailabilityType(UNDER_MAINTAIN);
            carRepo.save(car);

            rent.setRentType(PAY);
            rentRepo.save(rent);
        }
        paymentRepo.save(payment);
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayment() {
        return mapper.map(paymentRepo.findAll(), new TypeToken<ArrayList<PaymentDTO>>() {
        }.getType());
    }
}
