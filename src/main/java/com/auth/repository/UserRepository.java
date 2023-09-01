package com.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.model.user;

public interface UserRepository extends JpaRepository<user, Long> {
	Optional<user> findByUsername(String username);
	
	 Optional<user>	findByPasswordAndUsername(String password, String userName);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
}
