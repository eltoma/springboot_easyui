package com.lab.elto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by elotoma on 2017/7/3.
 */


@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${content}")
    private String content;

    @RequestMapping(value = { "/hello", "/hi"}, method = RequestMethod.GET)
    public String say() {
        return content;
    }
}
