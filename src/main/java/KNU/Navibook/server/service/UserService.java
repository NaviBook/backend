package KNU.Navibook.server.service;

import KNU.Navibook.server.domain.User;
import KNU.Navibook.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findOne(String userId){
        return userRepository.findByid(userId);
    }
}
