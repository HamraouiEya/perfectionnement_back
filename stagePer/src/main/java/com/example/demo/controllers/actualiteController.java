package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enteties.Actualite;
import com.example.demo.exeptions.ActualiteNotFoundException;
import com.example.demo.services.actualiteInterService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/actualites")
@CrossOrigin(origins = "http://localhost:4200")
public class actualiteController {
	
	  private final  actualiteInterService actualiteSer;

	    public actualiteController(actualiteInterService actualiteSer) {
	        this.actualiteSer = actualiteSer;
	    }
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/actualites/addAct")
    public boolean addAct(@RequestBody Actualite act)
    {
    	return actualiteSer.addActualite(act);
    }
    
    @GetMapping("/actualites")
    public List<Actualite> getAll()
    {
    	return actualiteSer.getAll();
    }
    
    @PutMapping("/actualites/{id}")
    public Actualite updateAct(@RequestBody Actualite act , @PathVariable("id") int id ) 
    {
    	try {
			return actualiteSer.updateActualite(act, id);
		} catch (ActualiteNotFoundException e) {
			 throw new RuntimeException(e);
		}
    }
    
    @GetMapping("/actualites/{id}")
    public Optional<Actualite> getById(@PathVariable ("id") int id)
    {
    	return actualiteSer.getActById(id);
    }
    
    @DeleteMapping("/del/{id}")
    public boolean deleteAct(@PathVariable ("id") int id)
    {
    	try {
			return actualiteSer.deleteActualite(id);
		} catch (ActualiteNotFoundException e) {
			 throw new RuntimeException(e);
		}
    }
    
}