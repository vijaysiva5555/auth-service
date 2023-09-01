package com.auth.model;


import java.util.Collection;

import javax.persistence.*;





@Entity
@Table( name = "users", 
        uniqueConstraints = { 
          @UniqueConstraint(columnNames = "username"),
          @UniqueConstraint(columnNames = "email") 
        })
public class user {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(length = 20)
  private String username;

  @Column(length = 20)
 
  private String email;

  @Column(length = 20)
  private String password;

  



public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}
