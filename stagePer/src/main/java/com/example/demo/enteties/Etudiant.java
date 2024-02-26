package com.example.demo.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String nom;
	String prenom;
	String email;
	String pays;
	String nationnalite;
	String telephone;
	String adresse;
	String niveauEtude;
	String formationDiplomante;
	String formationAccelere;
     boolean emailVerified;
	
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Etudiant(int id, String nom, String prenom, String email, String pays, String nationnalite, String telephone,
			String adresse, String niveauEtude, String formationDiplomante, String formationAccelere,
			boolean emailVerified) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pays = pays;
		this.nationnalite = nationnalite;
		this.telephone = telephone;
		this.adresse = adresse;
		this.niveauEtude = niveauEtude;
		this.formationDiplomante = formationDiplomante;
		this.formationAccelere = formationAccelere;
		this.emailVerified = emailVerified;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public String getFormationDiplomante() {
		return formationDiplomante;
	}

	public void setFormationDiplomante(String formationDiplomante) {
		this.formationDiplomante = formationDiplomante;
	}

	public String getFormationAccelere() {
		return formationAccelere;
	}

	public void setFormationAccelere(String formationAccelere) {
		this.formationAccelere = formationAccelere;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pays=" + pays
				+ ", nationnalite=" + nationnalite + ", telephone=" + telephone + ", adresse=" + adresse
				+ ", niveauEtude=" + niveauEtude + ", formationDiplomante=" + formationDiplomante
				+ ", formationAccelere=" + formationAccelere + ", emailVerified=" + emailVerified + "]";
	}

	
	
}
