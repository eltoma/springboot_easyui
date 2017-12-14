package com.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by elo toma on 2017/12/1.
 * 负责所有的html文件的路由
 */
@Controller
@RequestMapping("/pages/")
public class WebPageController {
    @RequestMapping("systemManager/userMan")
    public String userManPage() {
        return "/systemManager/user";
    }

    @RequestMapping("systemManager/log")
    public String log(){
        return "/systemManager/log";
    }

    @RequestMapping("projectManager/projectFile")
    public String projectFile(){
        return "/projectManager/projectFile";
    }
    @RequestMapping("projectManager/projectPeriod")
    public String projectPeriod(){
        return "/projectManager/projectPeriod";
    }

    @RequestMapping("entry/register")
    public String Register(){
        return "/entry/register";
    }

    @RequestMapping("activityManager/activity")
    public String activity(){
        return "/activityManager/activity";
    }
}

