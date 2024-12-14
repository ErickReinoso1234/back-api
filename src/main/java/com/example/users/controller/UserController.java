package com.example.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dto.UserRequestDto;
import com.example.users.service.UserService;

@RestController
@RequestMapping("api-users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDto userRequestDto) {
        String result = userService.registerUser(userRequestDto);
        if (result.contains("exitosamente")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRequestDto userRequestDto) {
        String result = userService.authenticateUser(userRequestDto.getCorreo(), userRequestDto.getPassword());
        if (result.equals("Autenticación exitosa")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}