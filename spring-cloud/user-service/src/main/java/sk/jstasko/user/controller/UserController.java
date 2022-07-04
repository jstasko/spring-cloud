package sk.jstasko.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.jstasko.user.entity.User;
import sk.jstasko.user.service.UserService;
import sk.jstasko.user.valueObjects.ResponseTemplate;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController");
        return this.userService.saveUser(user);
    }

    @GetMapping("{userId}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("userId") Long userId) {
        log.info("Inside getUserWithDepartment method of UserController");
        return this.userService.getUserWithDepartment(userId);
    }


}
