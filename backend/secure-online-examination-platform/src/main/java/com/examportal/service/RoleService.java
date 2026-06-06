package com.examportal.service;

import com.examportal.entity.Role;
import com.examportal.entity.enums.RoleType;
import com.examportal.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createDefaultRole(RoleType roleType) {

        Role role = new Role();
        role.setRoleName(roleType);

        return roleRepository.save(role);
    }

    public Role getRoleByName(RoleType roleType) {

        return roleRepository.findByRoleName(roleType)
                .orElseThrow(() ->
                        new RuntimeException("Role not found: " + roleType));
    }
}