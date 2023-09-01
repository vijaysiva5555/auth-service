package com.auth.controller;


import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.util.JwtUtil;
import com.auth.service.UserService;
import com.auth.util.ResponseInfo;
import com.auth.util.ResponseInfo.ResponseType;

import com.auth.model.user;

@RestController
public class AuthRestController {

	@Autowired
	UserService userservice; 
	ModelMapper mapper = new ModelMapper();
	ResponseEntity<Object> response = null;
	@PostMapping("/auth/login")
	public ResponseEntity<Object> login(@RequestBody user input) {
		user userDto = mapper.map(input, user.class);

		Map<String, Object> out =  userservice.validLogin(userDto);
		  response = new ResponseEntity<Object>(new ResponseInfo(ResponseType.SUCCESS, out), HttpStatus.OK);

		    return response;
	}

	@PostMapping("/auth/register")
	public ResponseEntity<Object> register(@RequestBody user input)throws Exception{
		user userDto = mapper.map(input, user.class);
		  Map<String, Object> out =  userservice.register(userDto);
		 
		  response = new ResponseEntity<Object>(new ResponseInfo(ResponseType.SUCCESS, out), HttpStatus.OK);

		    return response;
		
	}

}