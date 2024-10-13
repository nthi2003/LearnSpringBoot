package userRest.userRest.service;

import org.springframework.stereotype.Service;
import userRest.userRest.domain.User;
import userRest.userRest.repository.UserRepository;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    public User handleCreateUser(User user) {
      return this.userRepository.save(user);
    }

}
