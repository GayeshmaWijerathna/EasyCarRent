package lk.ijse.easycarrent.controller;

import lk.ijse.easycarrent.dto.CarDTO;
import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.embeded.ImageDTO;
import lk.ijse.easycarrent.embeded.Rate;
import lk.ijse.easycarrent.entity.Car;
import lk.ijse.easycarrent.service.CarService;
import lk.ijse.easycarrent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto, @ModelAttribute Rate rate, @ModelAttribute ImageDTO image) {
        dto.setImage(image);
        dto.setRentDurationPrice(rate);
        service.saveCar(dto);
        return new ResponseUtil("OK", "Successfully Registered!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/update")
    public ResponseUtil updateCar(@ModelAttribute CarDTO dto, @ModelAttribute Rate rate, @ModelAttribute ImageDTO image){
        dto.setImage(image);
        dto.setRentDurationPrice(rate);
        service.saveCar(dto);
        return new ResponseUtil("OK", "Successfully Updated! : " + dto.getCarId(), null);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteCar(@RequestParam String id){
        service.deleteCar(id);
        return new ResponseUtil("OK", "Successfully Deleted ! : "+ id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllCars")
    public ResponseUtil getAllCar() {
        return new ResponseUtil("OK", "Successfully Loaded! :", service.getAllCars());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/carIDGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        return service.carIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCar", params = {"carId"})
    public Car searchCusId(String carId) {
        return service.searchCarId(carId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/carCount")
    public @ResponseBody CustomDTO getSumCustomer() {
        return service.getSumCar();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/availableCarCount")
    public @ResponseBody CustomDTO getSumAvailableCar() {
        return service.getSumAvailableCar();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/reservedCarCount")
    public @ResponseBody CustomDTO getSumReservedCar() {
        return service.getSumReservedCar();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/maintainCar")
    public @ResponseBody CustomDTO getSumMaintainCar() {
        return service.getSumMaintainCar();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/underMaintainCar")
    public @ResponseBody CustomDTO getSumUnderMaintainCar() {
        return service.getSumUnderMaintainCar();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/filterCarDetails", params = {"categoryType", "fuelType"})
    public ArrayList<CarDTO> getFilerData(@RequestParam String categoryType, @RequestParam String fuelType) {
        return service.getFilerData(categoryType, fuelType);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/filterDetails", params = {"name", "fuelType","type", "transmissionType"})
    public ArrayList<CarDTO> filterCarDetails(@RequestParam String name, @RequestParam String fuelType,@RequestParam String type, @RequestParam String transmissionType) {
        return service.filterCarDetails(name, fuelType,type,transmissionType);
    }


}