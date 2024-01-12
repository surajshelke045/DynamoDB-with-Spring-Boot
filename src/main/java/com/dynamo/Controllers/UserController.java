package com.dynamo.Controllers;


import com.dynamo.Model.User;
import com.dynamo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        System.out.println("Post Api");
        User SavedUser = userService.SaveUser(user);
        return new ResponseEntity<User>(SavedUser, HttpStatus.OK);
    }
    
	@GetMapping("/home")
	public String home() {
		return "Welcome to Dynamo DB";
	}

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User SavedUser = userService.getUserById(userId);
        return new ResponseEntity<User>(SavedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{usedId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User Deleted Successfully");
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }
}


