package userRest.userRest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import userRest.userRest.domain.User;
import userRest.userRest.service.UserService;
import userRest.userRest.service.error.IdInvalidException;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;
    private final  PasswordEncoder passwordEncoder;

    public UserController(UserService userService , PasswordEncoder passwordEncoder) {

        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/user/create")
        public ResponseEntity<User> createNewUser(@RequestBody User req) {


        String handePassword = this.passwordEncoder.encode(req.getPassword());
        req.setPassword(handePassword);


        User createUser = this.userService.CreateNewUser(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) throws IdInvalidException {
        if(id >=1200){
            throw new IdInvalidException("ID khong lon hon 1200");
        }
         this.userService.DeleteUser(id);
//         return ResponseEntity.status(HttpStatus.OK).body("Xoa thanh cong");
         return ResponseEntity.ok("Xoa thanh cong");
    }
    @GetMapping("/user/getAllUser")
    public ResponseEntity<List<User>> GetALLUser() {
         this.userService.GetAllUser();
          return ResponseEntity.ok(this.userService.GetAllUser());
    }
    @GetMapping("/user/getUserId/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") long id) {
         this.userService.getUserById(id);
         return ResponseEntity.ok(this.userService.getUserById(id));
    }
    @PutMapping("/user")
    public  ResponseEntity<String> Updateuser(@RequestBody User req){
         User updateUser = this.userService.UpdateUser(req);
         return ResponseEntity.ok("Sua thanh cong");


    }


}
