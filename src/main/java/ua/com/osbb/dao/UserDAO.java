package ua.com.osbb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.osbb.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("from User u where u.username =:name")
    User findByUsername(@Param("name") String name);
}
