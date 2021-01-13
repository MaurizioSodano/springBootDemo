package com.soulsoftware.springmvcboot;

import com.soulsoftware.springmvcboot.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
public class HomeController {

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home() {

        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {


        int num3 = i + j;
        m.addAttribute("num3", num3);

        return "result";
    }

    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("alien") Alien a) {


        return "result";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m) {
        List<Alien> aliens= Arrays.asList(new Alien(101,"Pippo"),new Alien(200,"Pluto"));
        m.addAttribute("result",aliens.toString());
        return "showAliens";
    }

}
