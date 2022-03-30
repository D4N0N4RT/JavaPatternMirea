package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    @Qualifier("userService")
    UserService service;

    @GetMapping(value="")
    public ResponseEntity<List<User>> getFull() {
        final List<User> usrs = service.getUsers();
        return usrs != null ? new ResponseEntity<>(usrs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> read(@PathVariable(name="id") long id) {
        final User user = service.read(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value="")
    public ResponseEntity<?> addUser(User us){
        service.saveUser(us);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
}
