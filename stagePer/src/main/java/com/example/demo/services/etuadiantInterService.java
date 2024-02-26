package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.enteties.Etudiant;
import com.example.demo.exeptions.ActualiteNotFoundException;

public interface etuadiantInterService {
	
    public void verifyEmail(String token) ;
	public void addEtudiant(Etudiant et);
	public List<Etudiant> getEtudiants();
	public Optional<Etudiant> getEtudiantById(int id);
	public boolean deleteEtudiant(int id )throws ActualiteNotFoundException;
}
