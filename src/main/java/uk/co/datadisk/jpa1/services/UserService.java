package uk.co.datadisk.jpa1.services;

import org.springframework.data.domain.Example;
import uk.co.datadisk.jpa1.entities.User;
import uk.co.datadisk.jpa1.entities.UserDepartment;
import uk.co.datadisk.jpa1.entities.UserDepartmentId;

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
