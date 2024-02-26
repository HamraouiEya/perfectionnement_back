package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enteties.Actualite;
import com.example.demo.exeptions.ActualiteNotFoundException;
import com.example.demo.repositories.actualiteRep;

@Service
public class actualiteImplService  implements actualiteInterService{

	@Autowired 
	actualiteRep actualiteRep;
	
	public List<Actualite> getAll()
	{
		return actualiteRep.findAll();
	}
	
	public Optional<Actualite> getActById(int id)
	{
		return actualiteRep.findById(id);
	}
	
	 public Actualite addActualite(Actualite actualite) {
	        return actualiteRep.save(actualite);
	    }
	
	public boolean deleteActualite(int id ) throws ActualiteNotFoundException
	{
		Optional<Actualite> actualite = actualiteRep.findById(id);
		if(actualite.isPresent()) {
			actualiteRep.deleteById(id);
			return true;}
		else {
            throw new ActualiteNotFoundException("Actualite not found");
        }
	}
	
	public Actualite updateActualite(Actualite act , int id) throws ActualiteNotFoundException
	{
		Optional<Actualite> actualite = actualiteRep.findById(id);
	    if (actualite.isPresent()){
	    	Actualite actExistitante= actualite.get();
	    	actExistitante.setDate(act.getDate());
	    	actExistitante.setDescription(act.getDescription());
	    	actExistitante.setNom(act.getNom());
	    	actExistitante.setImg(act.getImg());
	    	return actualiteRep.save(actExistitante);
	    	}else {
	            throw new ActualiteNotFoundException("Actualite not found");
	        }
	    }

}
