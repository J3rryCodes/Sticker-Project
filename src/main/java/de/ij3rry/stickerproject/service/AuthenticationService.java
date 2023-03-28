package de.ij3rry.stickerproject.service;

import de.ij3rry.stickerproject.dto.LoginRequest;
import de.ij3rry.stickerproject.dto.LoginResponse;

public interface AuthenticationService {

    public LoginResponse login(LoginRequest loginRequest);
}
