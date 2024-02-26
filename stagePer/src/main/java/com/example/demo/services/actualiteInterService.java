package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.enteties.Actualite;
import com.example.demo.exeptions.ActualiteNotFoundException;

public interface actualiteInterService {

	public Actualite addActualite (Actualite act);
	public List<Actualite> getAll();
	public Optional<Actualite> getActById(int id);
	public boolean deleteActualite(int id ) throws ActualiteNotFoundException;
	public Actualite updateActualite(Actualite act , int id) throws ActualiteNotFoundException;
	
	
	
	
}
