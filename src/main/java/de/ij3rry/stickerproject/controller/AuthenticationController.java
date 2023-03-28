package de.ij3rry.stickerproject.controller;


import de.ij3rry.stickerproject.dto.LoginRequest;
import de.ij3rry.stickerproject.dto.LoginResponse;
import de.ij3rry.stickerproject.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    public final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){
        LoginResponse response = authenticationService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(response,HttpStatus.OK);
    }
}
