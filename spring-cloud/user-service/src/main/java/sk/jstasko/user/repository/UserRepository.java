package sk.jstasko.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.jstasko.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(Long userId);
}
