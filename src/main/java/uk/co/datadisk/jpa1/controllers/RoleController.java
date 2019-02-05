package uk.co.datadisk.jpa1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.datadisk.jpa1.entities.Role;
import uk.co.datadisk.jpa1.services.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/role/")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("listAllRoles")
    public List<Role> listAllNats() {
        List<Role> Roles = roleService.findAll();
        return Roles;
    }

    @GetMapping("findRole/{id}")
    public Role findUser(@PathVariable Long id) {
        Role role = roleService.findById(id);
        return role;
    }
}
