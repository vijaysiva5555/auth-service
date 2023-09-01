package com.auth.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.client.RestTemplate;

import com.auth.model.user;

import com.auth.repository.UserRepository;
import com.auth.util.JwtUtil;


import java.util.ArrayList;


@Configuration
public class UserService  {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public Map<String, Object> validLogin(user userDto) {
		Map<String, Object> out = new LinkedHashMap<>();
		Optional<user> user = userRepo.findByPasswordAndUsername(userDto.getPassword(), userDto.getUsername());
		if(user.isPresent()) {
			user userexist = user.get();
			String token = jwtUtil.generateToken(userexist.getUsername());
			
			
			out.put("userid", userexist.getId());
			out.put("mail", userexist.getEmail());
			out.put("name", userexist.getUsername());
			out.put("token", token);
			out.put("message", "user logged in successfully !");
		}else {
			out.put("message", "Login username or password incorrect !");
		}
		
		return out;
	}
	public Map<String, Object> register(user userDto) {
		Map<String, Object> out = new LinkedHashMap<>();
		Optional<user> oUser = userRepo.findByUsername(userDto.getUsername());
		if(oUser.isPresent()) {
			out.put("message", "User Already Exist");
		}else{
			userRepo.save(userDto);
		out.put("message", "Registered Successfully");
		}
	
		return out;
	}


	

}
