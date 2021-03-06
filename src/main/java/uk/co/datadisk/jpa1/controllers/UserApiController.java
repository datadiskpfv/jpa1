package uk.co.datadisk.jpa1.controllers;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.datadisk.jpa1.entities.Gender;
import uk.co.datadisk.jpa1.entities.User;
import uk.co.datadisk.jpa1.entities.UserDepartment;
import uk.co.datadisk.jpa1.entities.UserDepartmentId;
import uk.co.datadisk.jpa1.repositories.UserCriteriaRepository;
import uk.co.datadisk.jpa1.repositories.UserDepartmentRepository;
import uk.co.datadisk.jpa1.repositories.UserRepository;
import uk.co.datadisk.jpa1.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserApiController {

    private UserService userService;
    private UserRepository userRepository;
    private UserDepartmentRepository userDepartmentRepository;
    private UserCriteriaRepository userCriteriaRepository;

    public UserApiController(UserService userService, UserRepository userRepository, UserDepartmentRepository userDepartmentRepository, UserCriteriaRepository userCriteriaRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.userDepartmentRepository = userDepartmentRepository;
        this.userCriteriaRepository = userCriteriaRepository;
    }

    @GetMapping("listAllUsers")
    public List<User> listAllUsers() {
        return userService.findAll();
    }

    @GetMapping("findUser/{id}")
    public User findUser(@PathVariable Long id) {
        User user = userService.findById(id);
        return user;
    }

    @GetMapping("findUsername/{username}")
    public User findUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return user;
    }

    @GetMapping("findUsername/{username}/{department}")
    public User findUsername(@PathVariable String username, @PathVariable String department) {
        User user = userService.findByUsernameDepartment(username, department);
        return user;
    }

    @GetMapping("findUserByUsername/{username}")
    public User findUserByUsername(@PathVariable String username) {
        System.out.println("Username: " + username);
        User user = userRepository.findByUsernameExample(username);
        return user;
    }

    @GetMapping("findUserByUsernameGender/{username}/{gender}")
    public User findUserByUsername(@PathVariable String username, @PathVariable Gender gender) {
        System.out.println("Username: " + username);
        System.out.println("Gender: " + gender);
        User user = userRepository.findByUsernameGender(username, gender);
        return user;
    }

    @GetMapping("findUserDepartmentExample/{usernameId}/{departmentId}")
    public List<User> findUserByUsername(@PathVariable Long usernameId, @PathVariable Long departmentId) {
        System.out.println("Username ID: " + usernameId);
        System.out.println("Department ID: " + departmentId);

        UserDepartment userDepartment = new UserDepartment();
        UserDepartmentId userDepartmentId = new UserDepartmentId();

        userDepartment.setId(userDepartmentId);

        userDepartmentId.setUserId(usernameId);
        userDepartmentId.setDepartmentId(departmentId);
        userDepartment.setCreatedOn(null);                          // set to correct date or null

        Example<UserDepartment> userDepartmentExample = Example.of(userDepartment);

        List<User> user = userDepartmentRepository.findAll(userDepartmentExample);
        return user;
    }

    @GetMapping("findUserByCriteria/{username}")
    public User findUserByCriteria(@PathVariable String username) {

        System.out.println("Finding user using criteria builder");
        User user = userCriteriaRepository.findUser(username);
        return user;
    }

    @GetMapping("findUserByPredicate/{username}/{gender}")
    public User findUserByCriteria(@PathVariable String username, @PathVariable Gender gender) {

        System.out.println("Finding user using criteria and predicate builder");
        User user = userCriteriaRepository.findUserPredicate(username, gender);
        return user;
    }

    @GetMapping("findUserByEmailAddress/{email}")
    public User findUserByEmailAddress(@PathVariable String email) {

        System.out.println("Finding user using named query");
        User user = userRepository.fetchByEmailAddress(email);
        return user;
    }
}
