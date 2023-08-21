package com.paylify.model.repository;

import com.paylify.model.data.Role;
import com.paylify.model.repository.contract.IRoleRepo;
import com.paylify.model.repository.contract.RelationalBaseRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleRepo extends RelationalBaseRepo<Role, IRoleRepo> {

    private final IRoleRepo iRoleRepo;

    public RoleRepo(IRoleRepo iRoleRepo) {
        super(iRoleRepo, "Role");
        this.iRoleRepo = iRoleRepo;
    }

    public Role getByName(String name){
        return iRoleRepo.findByName(name).orElse(create(new Role()));
    }


}
