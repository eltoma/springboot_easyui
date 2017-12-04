package com.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by elotoma on 2017/12/1.
 * 负责所有的html文件的路由
 */
@Controller
@RequestMapping("/pages/")
public class WebPageController {
    @RequestMapping("systemManager/userMan")
    public String userManPage() {
        return "/systemManager/user";
    }
}

