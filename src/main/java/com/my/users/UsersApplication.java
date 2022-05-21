package com.my.users;

import com.my.users.service.MyService;
import lombok.AllArgsConstructor;
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

	private final MyService myService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// See https://habr.com/ru/post/347752/
		myService.method1();
	}
}
