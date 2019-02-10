package uk.co.datadisk.jpa1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.datadisk.jpa1.entities.User;
import uk.co.datadisk.jpa1.repositories.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/web/user/")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("listAllUsers")
    public String listAllUsers(Model model) {
        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);

        return "user/usersList";
    }
}
