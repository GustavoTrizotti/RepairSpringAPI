package com.prw3.auth.controller;

import com.prw3.auth.dto.LoginDTO;
import com.prw3.auth.dto.TokenDTO;
import com.prw3.user.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO dto) {
        var token = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var authentication = manager.authenticate(token);
        String jwtToken = tokenService.generate((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(jwtToken));
    }
}
