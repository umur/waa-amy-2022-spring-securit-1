package edu.miu.springdata.controller;

import edu.miu.springdata.dto.UserDto;
import edu.miu.springdata.dto.UserRespDto;
import edu.miu.springdata.entity.unidirectional.joincolumn.LoginRequest;
import edu.miu.springdata.entity.unidirectional.joincolumn.LoginResp;
import edu.miu.springdata.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uaa")
public class UaaController {

    private UserService userService;

    public UaaController(UserService uaaService) {
        this.userService = uaaService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LoginResp loginResp = userService.login(loginRequest);
        return ResponseEntity.ok().body(loginResp);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserRespDto> signup(@RequestBody UserDto userDto){
        UserRespDto userDtoResponse = userService.save(userDto);
        return ResponseEntity.ok(userDtoResponse);
    }

}
