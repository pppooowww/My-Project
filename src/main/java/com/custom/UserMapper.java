package com.custom;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDTO selectUserById(String id);


}
