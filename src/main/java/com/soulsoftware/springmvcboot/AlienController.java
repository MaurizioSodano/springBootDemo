package com.soulsoftware.springmvcboot;

import com.soulsoftware.springmvcboot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AlienController {
    @Autowired
    AlienRepo repo;

    @GetMapping("aliens")
    @ResponseBody
    public  List<Alien> getAliens(Model m) {
        // List<Alien> aliens= Arrays.asList(new Alien(101,"Pippo"),new Alien(200,"Pluto"));
        List<Alien> aliens = repo.findAll();

        return aliens;
    }

    @GetMapping("alien/{aid}")
    @ResponseBody
    public Alien getAlien(@PathVariable("aid")  int aid){
        Alien alien= repo.findById(aid).orElse(new Alien(0,""));
        return alien;
    }
}
