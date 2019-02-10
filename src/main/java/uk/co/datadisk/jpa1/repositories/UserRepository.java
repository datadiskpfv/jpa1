package uk.co.datadisk.jpa1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.co.datadisk.jpa1.entities.Gender;
import uk.co.datadisk.jpa1.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);

    User findByUsernameAndUserDepartmentsDepartmentName(String name, String department);

    //User findByNationalInsuranceNumber_NatNumber(String natNumber);

    @Query("SELECT u FROM #{#entityName} u where u.username = ?1")
    User findByUsernameExample(String username);

    @Query("SELECT u FROM User u WHERE u.gender = :gender and u.username = :username")
    User findByUsernameGender(
            @Param("username") String username,
            @Param("gender") Gender gender);

    User fetchByEmailAddress(@Param("email") String email);

}