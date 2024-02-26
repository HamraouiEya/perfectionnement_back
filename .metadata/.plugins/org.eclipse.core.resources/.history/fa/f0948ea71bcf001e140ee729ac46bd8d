package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enteties.Etudiant;
import com.example.demo.services.actualiteInterService;
import com.example.demo.services.etuadiantInterService;

@RestController
@CrossOrigin(origins = "*")
public class EtudiantController {

	 private final  etuadiantInterService etudiantSer;

	    public EtudiantController(etuadiantInterService etudiantSer) {
	        this.etudiantSer = etudiantSer;
	    }
	    
	    @PostMapping("/etudiants/add")
	    public ResponseEntity<String> registerUser(@RequestBody Etudiant etu) {
	    	etudiantSer.addEtudiant(etu);
	        return ResponseEntity.ok("Registration successful. Verification email sent.");
	    }

	    @GetMapping("/verify")
	    public String verifyEmail(@RequestParam("token") String token) {
	    	etudiantSer.verifyEmail(token);
	        return "Email verified successfully!";
	    }
}
