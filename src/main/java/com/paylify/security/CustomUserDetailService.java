package com.paylify.security;


import com.paylify.model.data.User;
import com.paylify.model.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public User loadUserByUsername(String email)  {
        return userRepo.getByEmail(email);
    }
}
