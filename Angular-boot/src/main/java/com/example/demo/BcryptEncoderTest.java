package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {
	
	public static void main(String[] args) {
		String encodedString="";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		for(int i=1; i<=10; i++) {
			encodedString = encoder.encode("pass");
		}
		
		System.out.println(encodedString);
		
		
	}

}
