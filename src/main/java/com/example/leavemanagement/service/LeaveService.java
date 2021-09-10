package com.example.leavemanagement.service;

import com.example.leavemanagement.model.Leave;

import java.util.List;

public interface LeaveService {
    public Leave save(Leave leave,Long userId);
    public Integer getLeave(Long userId);
}
