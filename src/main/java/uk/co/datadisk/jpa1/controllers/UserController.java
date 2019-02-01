package uk.co.datadisk.jpa1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
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
}
