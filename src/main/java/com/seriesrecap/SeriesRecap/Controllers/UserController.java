package com.seriesrecap.SeriesRecap.Controllers;


import java.util.List;

import com.seriesrecap.SeriesRecap.Entites.User;
import com.seriesrecap.SeriesRecap.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/seriesRecap/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> userList=userService.getAllUsers();

        return userList.isEmpty() ? new ResponseEntity<>(userList, HttpStatus.NO_CONTENT):
           new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);

        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser= userService.saveUser(user);

        return savedUser != null ? new ResponseEntity<>(savedUser, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editUserById(@PathVariable int id,
                                                @RequestBody User user) {

        User editedUser =userService.editUserById(id, user);

        return editedUser != null ? new ResponseEntity<>(editedUser, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable int id) {
        User user=userService.deleteUserById(id);

        return user != null ? new ResponseEntity<>(user, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
