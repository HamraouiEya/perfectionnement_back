package com.example.demo.enteties;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VerifyTokenEntity {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String token;
	    private String userEmail;
	    private LocalDateTime expirationDateTime;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public LocalDateTime getExpirationDateTime() {
			return expirationDateTime;
		}
		public void setExpirationDateTime(LocalDateTime expirationDateTime) {
			this.expirationDateTime = expirationDateTime;
		}
	    
	    
	    
}
