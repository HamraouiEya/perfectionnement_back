package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enteties.VerifyTokenEntity;

public interface tokenRep extends JpaRepository<VerifyTokenEntity,Long> {
	VerifyTokenEntity findByToken(String token);
}
