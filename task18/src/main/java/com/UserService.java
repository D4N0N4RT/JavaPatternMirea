package com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User read(long id) {
        log.info("Read user by id = {}", id);
        return userRepository.getById(id);
    }

    public List<User> readAll() {
        log.info("Read all users");
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        log.info("Save user {}", user);
        userRepository.save(user);
    }

    boolean update(User user, long id) {
        log.info("Update user {} by id = {}", user, id);
        user.setId(id);
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(long id) {
        log.info("Delete user by id = {}", id);
        userRepository.deleteById(id);
        return true;
    }

    List<User> findUsersByFirstName(String firstName) {
        log.info("Find all users by first name = {}", firstName);
        return userRepository.findAllByFirstName(firstName);
    }

    List<User> findUsersByLastName(String lastName) {
        log.info("Find all users by last name = {}", lastName);
        return userRepository.findAllByLastName(lastName);
    }
}
