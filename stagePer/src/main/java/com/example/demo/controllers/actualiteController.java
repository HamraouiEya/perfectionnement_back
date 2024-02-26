package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.enteties.Actualite;
import com.example.demo.exeptions.ActualiteNotFoundException;
import com.example.demo.services.actualiteInterService;
import java.io.File;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@CrossOrigin(origins = "*")
public class actualiteController {
	
	  private final  actualiteInterService actualiteSer;

	    public actualiteController(actualiteInterService actualiteSer) {
	        this.actualiteSer = actualiteSer;
	    }
	    
	    @Value("${file.upload.directory}")
	    private String uploadDirectory;

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
	        try {
	            // Save the file to the specified directory
	            String fileName = file.getOriginalFilename();
	            File destFile = new File(uploadDirectory + File.separator + fileName);
	            file.transferTo(destFile);

	            // Return a success message with the file name
	            return ResponseEntity.ok("File uploaded successfully: " + fileName);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
	        }
	    }
	    
	    @PostMapping("/addAct")
	    public ResponseEntity<Actualite> addActualite(@RequestBody Actualite act) {
	        try {
	            // Create Actualite object with data from the request body
	            Actualite actualite = new Actualite();
	            actualite.setNom(act.getNom());
	            actualite.setDate(act.getDate());
	            actualite.setDescription(act.getDescription());

	            // Set the image file name
	            actualite.setImg(act.getImg());

	            // Log the received date
	            System.out.println("Received date: " + act.getDate());

	            // Save Actualite
	            Actualite savedActualite = actualiteSer.addActualite(actualite);

	            return new ResponseEntity<>(savedActualite, HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }



	    @GetMapping("/actualites")
	    public List<Actualite> getAll() {
	        List<Actualite> actualites = actualiteSer.getAll();
	        
	        // Populate image paths for each Actualite object
	        for (Actualite actualite : actualites) {
	            String imgFileName = actualite.getImg();
	            String imgPath = uploadDirectory + File.separator + imgFileName;
	            actualite.setImg(imgPath);
	        }
	        
	        return actualites;
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
