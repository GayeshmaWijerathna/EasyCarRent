package lk.ijse.easycarrent.controller;


import lk.ijse.easycarrent.dto.AdminDTO;
import lk.ijse.easycarrent.service.AdminService;
import lk.ijse.easycarrent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@RequestBody AdminDTO dto) {
        service.saveAdmin(dto);
        System.out.println(dto);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @PutMapping
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto) {
        service.updateAdmin(dto);
        return new ResponseUtil("OK", "Successfully Updated.! :" + dto.getUserId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"adminId"})
    public ResponseUtil deleteAdmin(@RequestParam String adminId) {
        service.deleteAdmin(adminId);
        return new ResponseUtil("OK", "Successfully Deleted.! :" + adminId, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public ResponseUtil getAllAdmin() {
        return new ResponseUtil("OK", "Successfully Loaded.! :", service.getAllAdmin());
    }

}