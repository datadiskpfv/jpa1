package uk.co.datadisk.jpa1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.datadisk.jpa1.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);

    User findByUsernameAndUserDepartmentsDepartmentName(String name, String department);
}