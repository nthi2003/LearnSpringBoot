package userRest.userRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userRest.userRest.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
