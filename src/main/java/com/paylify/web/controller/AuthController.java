package com.paylify.web.controller;

import com.paylify.model.dto.LoginDTO;
import com.paylify.model.dto.ResponseDTO;
import com.paylify.model.dto.UserDTO;
import com.paylify.service.AuthService;
import com.paylify.web.response.LoginResponse;
import com.paylify.web.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/quick-pay/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO> signup(@RequestBody @Valid UserDTO userDTO) {
        UserResponse response = authService.createUser(userDTO);
        return ResponseEntity.ok(new ResponseDTO(true, "User is successfully created", response));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login( @RequestBody @Valid LoginDTO loginDTO) {
        LoginResponse response = authService.login(loginDTO);
        return ResponseEntity.ok(new ResponseDTO(true, "User is successfully logged in", response ));
    }
}

