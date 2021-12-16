package com.example.travelezweb.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travelezweb.model.User;
import org.springframework.data.jpa.repository.Query;
public interface UserRepository  extends JpaRepository<User, Integer> {


    @Query("select u from User u where u.email = ?1")
    User findPasswordByEmail(String username);

    @Query("select u from User u where u.id = ?1")
    User findPasswordById(Integer id);
}
