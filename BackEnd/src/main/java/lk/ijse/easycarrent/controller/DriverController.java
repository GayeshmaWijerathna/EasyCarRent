package lk.ijse.easycarrent.controller;

import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.dto.DriverDTO;
import lk.ijse.easycarrent.dto.UserDTO;
import lk.ijse.easycarrent.embeded.Name;
import lk.ijse.easycarrent.entity.Driver;
import lk.ijse.easycarrent.service.DriverService;
import lk.ijse.easycarrent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        driverDTO.setUser(userDTO);
        driverDTO.setName(name);
        service.saveDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Registered!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/update")
    public ResponseUtil updateDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        driverDTO.setUser(userDTO);
        driverDTO.setName(name);
        service.updateDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Updated ! :" + driverDTO.getUserId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteDriver(@RequestParam String id) {
        service.deleteDriver(id);
        return new ResponseUtil("OK", "Successfully Deleted ! :" + id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllDrivers")
    public ResponseUtil getAllDriver() {
        return new ResponseUtil("OK", "Successfully Loaded ! :", service.getAllDrivers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAvailabilityDrivers")
    public ResponseUtil getAllAvailableDriver() {
        return new ResponseUtil("OK", "Successfully Loaded ! :", service.getAllAvailableDrivers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverIdGenerate")
    public @ResponseBody
    CustomDTO customerIdGenerate() {
        return service.userIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchDriver", params = {"driverId"})
    public Driver searchDriverId(String driverId) {
        return service.searchDriverId(driverId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverCount")
    public @ResponseBody CustomDTO getSumCustomer() {
        return service.getSumDriver();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverAvailableCount")
    public @ResponseBody CustomDTO getSumAvailableDriver() {
        return service.getSumAvailableDriver();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverUnavailableCount")
    public @ResponseBody CustomDTO getSumUnavailableDriver() {
        return service.getSumUnavailableDriver();
    }
}