package com.soulsoftware.springmvcboot;

import com.soulsoftware.springmvcboot.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository<Alien,Integer> {

}
