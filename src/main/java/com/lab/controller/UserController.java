package com.lab.controller;

import com.lab.model.SubmitResult;
import com.lab.model.User;
import com.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lab.constant.Constant.SESSIONKEY_USER_NAME;

/**
 * Created by elotoma on 2017/12/11.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public SubmitResult addUser(@RequestBody User user) {
        SubmitResult res = new SubmitResult();
        List<User> users = userService.selectByUsername(user);
        if(users.size() > 0) {
            res.setSuccess(false);
            res.setMsg("用户名："+ user.getUsername() + "已经存在");
            return res;
        }

        // 设置创建时间
        user.setCreatetime(new Date());

        userService.addUser(user);
        res.setSuccess(true);
        return res;
    }

    @RequestMapping(value = "/all/")
    public Object findAllUser(@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize){
        Map res = new HashMap<String, Object>();
        List<User> users = userService.findAllUser(pageNum,pageSize);
        res.put("total", users.size());
        res.put("rows", users);
        return res;
    }

    @RequestMapping("/annotation/all")
    public Object findAllUserByAnnotation(){
        return userService.findAllUserByAnnotation(1,3);
    }
}
