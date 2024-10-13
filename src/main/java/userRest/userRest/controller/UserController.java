package userRest.userRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import userRest.userRest.domain.User;
import userRest.userRest.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user/create")
        public User createNewUser(@RequestBody User req) {


        User createUser = this.userService.handleCreateUser(req);

        return createUser;
    }

}
