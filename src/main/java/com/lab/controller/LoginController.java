package com.lab.controller;

import com.lab.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.lab.constant.Constant.SESSIONKEY_USER_NAME;

/**
 * Created by elotoma on 2017/12/1.
 * 登录和系统入口相关的Controller
 */

@Controller
public class LoginController {

    @RequestMapping("/main")
    public String mainPage() {
        return "/entry/main";
    }

    @RequestMapping("/")
    public String index() {
        return "/entry/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public Result login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        HttpSession session) {

        Result res = new Result();
        if(checkAccess(userName, password)) {
            res.setSuccess(true);

            session.setAttribute(SESSIONKEY_USER_NAME, userName);
        } else {
            res.setSuccess(false);
            res.setMsg("用户名或则密码错误！");
        }

        return res;
    }

    private boolean checkAccess(String username, String password) {
        if("admin".equals(username) && "123".equals(password)) {
            return true;
        }
        return false;
    }
}
