package com.springbootbasicsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootBasicSecurityApplication  implements CommandLineRunner{

	@Autowired
	PasswordEncoder encoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//store in db password
		String encode = encoder.encode("xyz");
		System.out.println(encode);
	}

}
