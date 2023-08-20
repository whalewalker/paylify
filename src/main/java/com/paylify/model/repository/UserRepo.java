package com.paylify.model.repository;

import com.paylify.model.data.User;
import com.paylify.model.repository.contract.IUserRepo;
import com.paylify.model.repository.contract.RelationalBaseRepo;
import com.paylify.web.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepo extends RelationalBaseRepo<User, IUserRepo> {

    private final IUserRepo iUserRepo;

    public UserRepo(IUserRepo iUserRepo) {
        super(iUserRepo, "User");
        this.iUserRepo = iUserRepo;
    }

    public User getByEmail(String email){
        Optional<User> user = iUserRepo.findByEmail(email);
        if (user.isEmpty()) throw new ResourceNotFoundException("User not found!");
        return user.get();
    }

    public boolean existByEmail(String email) {
        return iUserRepo.existsByEmail(email);
    }
}
