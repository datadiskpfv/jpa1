package uk.co.datadisk.jpa1.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import uk.co.datadisk.jpa1.entities.User;
import uk.co.datadisk.jpa1.entities.UserDepartment;
import uk.co.datadisk.jpa1.entities.UserDepartmentId;

import java.util.List;

public interface UserDepartmentRepository extends CrudRepository<UserDepartment, UserDepartmentId> {

    List<User> findAll(Example<UserDepartment> userDepartment);
}
