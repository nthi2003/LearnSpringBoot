package userRest.userRest.service;

import org.springframework.stereotype.Service;
import userRest.userRest.domain.User;
import userRest.userRest.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    public User CreateNewUser(User user) {
      return this.userRepository.save(user);
    }
    public List<User> GetAllUser() {

        return this.userRepository.findAll();
    }
    public void DeleteUser(long id){
         this.userRepository.deleteById(id);
    }
    public Optional<User> getUserById(long id) {
        return this.userRepository.findById(id);
    }
    public User UpdateUser(User reqUser ) {
        Optional<User> currentUserOptional = this.getUserById(reqUser.getId());
        if (currentUserOptional.isPresent()) {
            User currentUser = currentUserOptional.get();
            currentUser.setUsername(reqUser.getUsername());
            currentUser.setEmail(reqUser.getEmail());
            currentUser.setPassword(reqUser.getPassword());
            return this.userRepository.save(currentUser);
        }
        else {
            return null;
        }


    }


}
