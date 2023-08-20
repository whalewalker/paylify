package com.paylify.service.contract;

import com.paylify.model.dto.LoginDTO;
import com.paylify.model.dto.UserDTO;
import com.paylify.web.response.LoginResponse;
import com.paylify.web.response.UserResponse;

public interface IAuthService {
    UserResponse createUser(UserDTO userDTO);
    LoginResponse login(LoginDTO loginDTO);
}
