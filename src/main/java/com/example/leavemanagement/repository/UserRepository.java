package com.example.leavemanagement.repository;

import com.example.leavemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   User  findByUsername(String username);
   User findByUsernameAndPassword(String username, String password);

   @Query(value = "SELECT * FROM user u WHERE u.id=userId ORDER BY id DESC LIMIT 1", nativeQuery = true)
   User findOneUser(@Param("userId") Long userId);
}
