package com.lab.service;

import com.lab.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by elotoma on 2017/12/11.
 */


public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

}
