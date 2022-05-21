package com.my.users;

import com.my.users.service.MyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class UsersApplication implements ApplicationRunner {
	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Autowired
	private MyService myService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		myService.method1();
	}
}
