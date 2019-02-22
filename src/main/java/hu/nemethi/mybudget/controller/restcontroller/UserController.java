package hu.nemethi.mybudget.controller.restcontroller;

import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/user", produces = "application/json", consumes = "application/json")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto resp = userServiceImpl.create(userDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<Void> deleteUser(@RequestParam UUID userId){
        userServiceImpl.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("modify")
    public ResponseEntity<UserDto> modifyUser(UserDto userDto){
        UserDto resp = userServiceImpl.modify(userDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<Void> login(@RequestBody UserDto userDto){
        UserDto resp = userServiceImpl.login(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("logout")
    public ResponseEntity<Void> logout(@RequestParam Integer userId){
        userServiceImpl.logout(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
