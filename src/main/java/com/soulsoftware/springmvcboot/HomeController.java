package com.soulsoftware.springmvcboot;

import com.soulsoftware.springmvcboot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    AlienRepo repo;

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

        repo.save(a);
        return "result";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m) {
       // List<Alien> aliens= Arrays.asList(new Alien(101,"Pippo"),new Alien(200,"Pluto"));
        m.addAttribute("result",repo.findAll());
        return "showAliens";
    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam int aid,Model m){
        m.addAttribute("result",repo.findById(aid));
        return "showAliens";
    }

    @GetMapping("getAlienByName")
    public String getAlienByName(@RequestParam String aname,Model m){
        m.addAttribute("result",repo.find(aname));
        return "showAliens";
    }

}
