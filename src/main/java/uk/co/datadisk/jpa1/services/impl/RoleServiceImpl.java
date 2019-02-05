package uk.co.datadisk.jpa1.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.co.datadisk.jpa1.entities.Role;
import uk.co.datadisk.jpa1.exceptions.NotFoundException;
import uk.co.datadisk.jpa1.repositories.RoleRepository;
import uk.co.datadisk.jpa1.services.NatService;
import uk.co.datadisk.jpa1.services.RoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository RoleRepository;

    public RoleServiceImpl(RoleRepository RoleRepository) {
        this.RoleRepository = RoleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(Long id) {
        return RoleRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("User Not Found. For ID value: " + id.toString()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {

        List<Role> Roles = RoleRepository.findAll();
//        System.out.println("Found Users");
//        System.out.println("-----------------------------------");
//        for(Role role : Roles)
//            System.out.println(role.getId() + " " + role.getName());

        return Roles;
    }


}
