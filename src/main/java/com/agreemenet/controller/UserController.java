package com.agreemenet.controller;


import com.agreemenet.dto.UserDto;
import com.agreemenet.model.User;
import com.agreemenet.service.UserService;
import com.agreemenet.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<ResponseData<User>> create(@RequestBody UserDto userDto) {
        User user = userService.createUser(userDto);
        return new ResponseEntity<>(new ResponseData<>(user), HttpStatus.OK);
    }

}
