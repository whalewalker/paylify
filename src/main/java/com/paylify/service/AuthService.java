package com.paylify.service;

import com.paylify.model.data.User;
import com.paylify.model.dto.LoginDTO;
import com.paylify.model.dto.UserDTO;
import com.paylify.model.repository.RoleRepo;
import com.paylify.model.repository.UserRepo;
import com.paylify.security.JwtTokenProvider;
import com.paylify.service.contract.IAuthService;
import com.paylify.web.exception.BadRequestException;
import com.paylify.web.response.LoginResponse;
import com.paylify.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper mapper;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;
    private static final String ROLE_NAME = "ROLE_USER";

    @Override
    public UserResponse createUser(UserDTO userDTO)  {
        if (userRepo.existByEmail(userDTO.getEmail())) {
            throw new BadRequestException("Email is already registered");
        }
        User user = mapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(List.of(roleRepo.getByName(ROLE_NAME)));

        return mapper.map(user, UserResponse.class);
    }

    @Override
    public LoginResponse login(LoginDTO loginDTO) {
        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getAccountNumber(),
                            loginDTO.getAccountPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = tokenProvider.generateToken(loginDTO.getAccountNumber());
            return new LoginResponse(token);
        } catch (BadCredentialsException | IllegalArgumentException ex) {
            throw new BadRequestException("Invalid credentials");
        }
    }

}
