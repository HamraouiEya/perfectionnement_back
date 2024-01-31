package com.example.demo.enteties;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Actualite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String nom;
	String description;
	Date date;
	@Lob
	@Column(name = "file_content", columnDefinition = "BLOB")
	private byte[] img;
	
	public Actualite() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Actualite(int id, String nom, String description, Date date, byte[] img) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.date = date;
		this.img = img;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "actualite [id=" + id + ", nom=" + nom + ", description=" + description + ", date=" + date + ", img="
				+ img + "]";
	}
	
}
