package com.soulsoftware.springmvcboot;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        //System.out.println("home page requested");
        return "index.jsp";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m){


        int num3=i+j;
        m.addAttribute("num3",num3);

        return "result";
    }
}
