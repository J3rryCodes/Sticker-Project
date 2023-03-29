package de.ij3rry.stickerproject.service.impl;

import de.ij3rry.stickerproject.dto.LoginRequest;
import de.ij3rry.stickerproject.dto.LoginResponse;
import de.ij3rry.stickerproject.service.AuthenticationService;
import de.ij3rry.stickerproject.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final JwtUtils jwtUtils;

    private final ReactiveAuthenticationManager authenticationManager;
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.userName(),loginRequest.password()));
        UserDetails userDetails = userService.findByUsername(loginRequest.userName()).block();
        String token = jwtUtils.generateToken(userDetails);
        return new LoginResponse(token);
    }
}
