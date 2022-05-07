package assignment.lab4.controller;

import assignment.lab4.entity.User;
import assignment.lab4.model.LoginRequest;
import assignment.lab4.model.LoginResponse;
import assignment.lab4.model.RefreshTokenRequest;
import assignment.lab4.service.UaaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/uaa")
//@CrossOrigin
public class UaaController {

    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
    }

@PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }


   @PostMapping("/signup")
   public ResponseEntity<?> signUp(@RequestBody User user) {
       System.out.println("Helllllo");
        uaaService.signUp(user);
       return ResponseEntity.ok().body("fgdfgfgfg");
    }





    @GetMapping
    public List<User> getALL() {
        return uaaService.getAll();
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return uaaService.refreshToken(refreshTokenRequest);
    }

}
