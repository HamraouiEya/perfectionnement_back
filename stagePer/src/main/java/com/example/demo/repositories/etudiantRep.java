package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enteties.Etudiant;

public interface etudiantRep extends JpaRepository <Etudiant,Integer>{

	 Etudiant findByEmail(String email);
}
