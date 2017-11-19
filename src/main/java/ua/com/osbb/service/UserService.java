package ua.com.osbb.service;

import org.springframework.data.repository.query.Param;
import ua.com.osbb.entity.User;

public interface UserService {

    void save(User user);
    User findByUsername(String name);

}
