package lk.ijse.easycarrent.controller;

import lk.ijse.easycarrent.dto.CustomDTO;
import lk.ijse.easycarrent.dto.RegUserDTO;
import lk.ijse.easycarrent.dto.UserDTO;
import lk.ijse.easycarrent.embeded.Name;
import lk.ijse.easycarrent.entity.Reg_User;
import lk.ijse.easycarrent.service.Reg_UserService;
import lk.ijse.easycarrent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reg_User")
public class RegisteredUserController {

    @Autowired
    private Reg_UserService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveUser(@ModelAttribute RegUserDTO regUserDTO, @ModelAttribute UserDTO user, @ModelAttribute Name name) {
        regUserDTO.setName(name);
        regUserDTO.setUser(user);
        System.out.println(regUserDTO);
        service.saveUser(regUserDTO);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/update")
    public ResponseUtil updateUser(@ModelAttribute RegUserDTO regUserDTO, @ModelAttribute UserDTO user, @ModelAttribute Name name) {
        regUserDTO.setName(name);
        regUserDTO.setUser(user);
        System.out.println(user);
        System.out.println(name);
        System.out.println(regUserDTO);
        service.updateUser(regUserDTO);
        return new ResponseUtil("OK", "Successfully Updated. :" + regUserDTO.getUserId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteUser(@RequestParam String id) {
        service.deleteUser(id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllUsers")
    public ResponseUtil getAllUser() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllUser());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/reg_UserIdGenerate")
    public @ResponseBody
    CustomDTO customerIdGenerate() {
        return service.userIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCustomer", params = {"cus_Id"})
    public Reg_User searchDriverId(String cus_Id) {
        return service.searchUserId(cus_Id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/customerCount")
    public @ResponseBody CustomDTO getSumCustomer() {
        return service.getSumUser();
    }

}