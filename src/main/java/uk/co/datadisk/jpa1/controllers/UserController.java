package uk.co.datadisk.jpa1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.datadisk.jpa1.entities.User;
import uk.co.datadisk.jpa1.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
}
