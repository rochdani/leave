package com.example.leavemanagement.controller;

import com.example.leavemanagement.model.Leave;
import com.example.leavemanagement.model.User;
import com.example.leavemanagement.service.LeaveService;
import com.example.leavemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")

public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/{userId}/apply")
    public Leave  save(@PathVariable(value = "userId") Long userId,@RequestBody Leave leave) throws Exception {
       Leave leave1 =leaveService.save(leave,userId);
       return  leave1;

    }

    @GetMapping("/getLeave")
//    public List<Leave> getLeave(@PathVariable(name = "userId") Long userId){
    public Integer getLeave( Long userId){
      return leaveService.getLeave(userId);

    }

}
