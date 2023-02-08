package KNU.Navibook.server.repository;

import KNU.Navibook.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> { //UserId type is String.
    User findByid(String id);
}
