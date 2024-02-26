package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.enteties.Actualite;
import com.example.demo.enteties.Etudiant;
import com.example.demo.enteties.VerifyTokenEntity;
import com.example.demo.exeptions.ActualiteNotFoundException;
import com.example.demo.repositories.etudiantRep;
import com.example.demo.repositories.tokenRep;

@Service
public class EtudiantImplService implements etuadiantInterService{

	@Autowired
	etudiantRep etudiantRep;
	
	 @Autowired
	 EmailService emailService;
	 
	 @Autowired
	 tokenRep tokenRep;
	 
	  public void addEtudiant(Etudiant et) {
	        etudiantRep.save(et);

	        // Generate a secure and unique token
	        String secret = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
	        String token = generateToken(et.getEmail(), secret);

	        // Save the verification token to the repository
	       // VerifyTokenEntity verificationToken = new VerifyTokenEntity();
	       // verificationToken.setToken(token);
	       // verificationToken.setUserEmail(et.getEmail());
	      //  tokenRep.save(verificationToken);

	        // Construct the verification link and email body
	    //    String verificationLink = "http://localhost:4200/verify?token=" + token;
	         String domaine= et.getFormationDiplomante();
	        String emailBody = "\n Bonjour,\n \n Nous avons bien reçu votre demande d'inscription au sein de L'académie Sherbrooke pour " + domaine + "\n \n Pour toute question ou préoccupation, n'hésitez pas à nous contacter. Nous sommes là pour vous aider.\n \n Nous vous remercions pour votre confiance.\n \n \n Académie Sherbrooke";

	        // Send the verification email
	        emailService.sendVerificationEmail(et.getEmail(), "Académie Sherbrooke: "+domaine.toUpperCase()+":Confirmation d'Inscription en ligne", emailBody);
	       
	    }

	    private String generateToken(String userEmail, String secret) {
	        return JWT.create()
	                .withIssuer("StagePer") 
	                .withSubject(userEmail)
	                .sign(Algorithm.HMAC256(secret));
	    }

	    public void verifyEmail(String token) {
	        VerifyTokenEntity verificationToken = tokenRep.findByToken(token);
	        if (verificationToken != null) {
	            Etudiant et = etudiantRep.findByEmail(verificationToken.getUserEmail());
	            if (et != null) {
	                et.setEmailVerified(true);
	                tokenRep.delete(verificationToken);
	            } else {
	                System.out.println("No user found with email: " + verificationToken.getUserEmail());
	            }
	        } else {
	            System.out.println("No verification token found with token: " + token);
	        }
	    }


	
	public List<Etudiant> getEtudiants()
	{
		return etudiantRep.findAll();
	}
	
	public Optional<Etudiant> getEtudiantById(int id)
	{
		return etudiantRep.findById(id);
	}
	
	public boolean deleteEtudiant(int id ) throws ActualiteNotFoundException
	{
		Optional<Etudiant> actualite = etudiantRep.findById(id);
		if(actualite.isPresent()) {
			etudiantRep.deleteById(id);
			return true;}
		else {
            throw new ActualiteNotFoundException("Etuadiant not found");
        }
	}
}