package com.ms.user.Controllers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ms.user.dtos.UserRequestDTO;
import com.ms.user.models.User;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        var user = new User();
        BeanUtils.copyProperties(userRequestDTO, user);
        userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
