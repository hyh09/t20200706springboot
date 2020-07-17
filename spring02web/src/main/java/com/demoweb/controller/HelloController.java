package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2020/7/17.
 */
@Controller
public class HelloController {

    @RequestMapping("/")

    public  String get1(){
        return  "init";
    }
}
