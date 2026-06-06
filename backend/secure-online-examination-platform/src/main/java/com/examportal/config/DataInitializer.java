package com.examportal.config;

import com.examportal.entity.Role;
import com.examportal.entity.enums.RoleType;
import com.examportal.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {

        createRoleIfNotExists(RoleType.ADMIN);
        createRoleIfNotExists(RoleType.RECRUITER);
        createRoleIfNotExists(RoleType.CANDIDATE);
    }

    private void createRoleIfNotExists(RoleType roleType) {

        if (roleRepository.findByRoleName(roleType).isEmpty()) {

            Role role = new Role();
            role.setRoleName(roleType);

            roleRepository.save(role);
        }
    }
}