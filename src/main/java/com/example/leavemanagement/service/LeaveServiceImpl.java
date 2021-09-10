package com.example.leavemanagement.service;

import com.example.leavemanagement.model.Leave;
import com.example.leavemanagement.model.User;
import com.example.leavemanagement.repository.LeaveRepository;
import com.example.leavemanagement.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements  LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    private UserRepository userRepository;

    @Override
    public Leave save(Leave leave, Long userId) {
        leave.setAnnual(20);
        leave.setSick("20");
        User user = userRepository.findOneUser(userId);

        leave.setUser(user);
//        userRepository.findById(userId).map(user -> {
//            leave.setUser(user);
////            return  leaveRepository.save(leave);
//        }).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        return  leaveRepository.save(leave);
    }

    @Override
    public Integer getLeave(Long userId) {

//        Leave leave= leaveRepository.findTopByOrderByUserIdDesc(userId);
         Integer leave= leaveRepository.findLastCont(userId);
         return  null;
    }
}
