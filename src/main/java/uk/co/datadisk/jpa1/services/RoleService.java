package uk.co.datadisk.jpa1.services;

import uk.co.datadisk.jpa1.entities.Role;

import java.util.List;

public interface RoleService {

    // need CRUD methods
    // CREATE


    // READ
    Role findById(Long id);
    List<Role> findAll();

    // UPDATE


    // DELETE

}
