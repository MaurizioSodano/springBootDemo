package com.soulsoftware.springmvcboot;

import com.soulsoftware.springmvcboot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlienController {
    @Autowired
    AlienRepo repo;

    @GetMapping("aliens")
    public List<Alien> getAliens() {
        // List<Alien> aliens= Arrays.asList(new Alien(101,"Pippo"),new Alien(200,"Pluto"));
        List<Alien> aliens = repo.findAll();

        return aliens;
    }

    @GetMapping("alien/{aid}")
    public Alien getAlien(@PathVariable("aid") int aid) {
        Alien alien = repo.findById(aid).orElse(new Alien(0, ""));
        return alien;
    }

    @PostMapping("alien")
    public Alien addAlien(Alien alien) {
        repo.save(alien);
        return alien;
    }

}
