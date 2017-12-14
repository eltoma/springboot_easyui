package com.lab.dao;

import com.lab.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnnotationUserMapper {
    @Select("SELECT * FROM user")
    @Results()
    List<User> selectAllUser();
}