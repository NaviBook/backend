package KNU.Navibook.server.repository;

import KNU.Navibook.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByid(String id);
}
