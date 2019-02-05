package uk.co.datadisk.jpa1.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.co.datadisk.jpa1.entities.User;
import uk.co.datadisk.jpa1.exceptions.NotFoundException;
import uk.co.datadisk.jpa1.repositories.UserRepository;
import uk.co.datadisk.jpa1.services.UserService;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("User Not Found. For ID value: " + id.toString()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {

        List<User> users = userRepository.findAll();
//        System.out.println("Found Users");
//        System.out.println("-----------------------------------");
//
//        for(User user : users)
//            System.out.println(user.toString());

        return users;
    }


}
