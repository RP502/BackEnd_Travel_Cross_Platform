package com.java.travel_cross_platform_be.Service.Implement;

import com.java.travel_cross_platform_be.Model.Entity.Role;
import com.java.travel_cross_platform_be.Model.Enum.ERole;
import com.java.travel_cross_platform_be.Repository.Interface.RoleRepository;
import com.java.travel_cross_platform_be.Service.Interface.InitDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitServiceImpl implements InitDataService {

    private final RoleRepository roleRepository;

    @Transactional(rollbackFor = Exception.class)
    public void initALl() {
        initRole();
        initUser();
        initTour();
    }
    @Override
    public void initRole() {
        List<Role> roles = List.of(
                new Role(ERole.ROLE_ADMIN),
                new Role(ERole.ROLE_USER)
        );
        roleRepository.saveAll(roles);
    }

    @Override
    public void initUser() {

    }

    @Override
    public void initTour() {

    }


}
