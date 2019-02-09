package uk.co.datadisk.jpa1.services;

import uk.co.datadisk.jpa1.entities.User;

import java.util.List;

public interface UserService {

    // need CRUD methods
    // CREATE


    // READ
    User findById(Long id);
    List<User> findAll();
    User findByUsername(String name);
    User findByUsernameDepartment(String name, String department);

    // UPDATE


    // DELETE

}
