package com.jwt.security;


import lombok.Data;

@Data
public class JwtRequest {
   
    private String password;
	private String Email;
}
