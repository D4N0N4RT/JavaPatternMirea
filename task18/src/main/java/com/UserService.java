package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User read(long id){
        return userRepository.getById(id);
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    boolean update(User user, long id) {
        user.setId(id);
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(long id){
        userRepository.deleteById(id);
        return true;
    }

    List<User> findUsersByFirstName(String firstName){
        return userRepository.findAllByFirstName(firstName);
    }

    List<User> findUsersByLastName(String lastName){
        return userRepository.findAllByLastName(lastName);
    }
}
