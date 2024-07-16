package com.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private UserMapper userMapper;

    public UserDTO getUserById(String id) {
        return userMapper.selectUserById(id);
    }
}
