package com.example.leavemanagement.repository;

import com.example.leavemanagement.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.Optional;

@Repository
public interface LeaveRepository extends JpaRepository<Leave,Long> {


//    public Leave findTopByOrderByUserIdDesc(Long userId);
  @Query(value = "SELECT annual_cont FROM leave l WHERE l.user_id=userId ORDER BY id DESC LIMIT 1", nativeQuery = true)
  Integer findLastCont(@Param("userId") Long userId);



}
