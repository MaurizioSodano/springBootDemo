package com.soulsoftware.springmvcboot;

import com.soulsoftware.springmvcboot.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien,Integer> {

    List<Alien> findByAnameOrderByAid(String aname); //Query DSL Domain Specific Language
}
