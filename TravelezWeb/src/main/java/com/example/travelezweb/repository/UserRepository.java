package com.example.travelezweb.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travelezweb.model.User;
public interface UserRepository  extends JpaRepository<User, Long> {


}
