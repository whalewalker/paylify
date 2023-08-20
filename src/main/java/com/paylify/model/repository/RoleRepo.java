package com.paylify.model.repository;

import com.paylify.model.data.Role;
import com.paylify.model.repository.contract.IRoleRepo;
import com.paylify.model.repository.contract.RelationalBaseRepo;

public class RoleRepo extends RelationalBaseRepo<Role, IRoleRepo> {

    private final IRoleRepo iRoleRepo;

    public RoleRepo(IRoleRepo iRoleRepo, String name) {
        super(iRoleRepo, "Role");
        this.iRoleRepo = iRoleRepo;
    }

    public Role getByName(String name){
        Role role = iRoleRepo.findByName("ROLE_USER").orElse(new Role("ROLE_USER"));
        return create(role);
    }
}
