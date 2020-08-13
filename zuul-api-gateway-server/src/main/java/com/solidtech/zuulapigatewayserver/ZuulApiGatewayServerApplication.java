package com.solidtech.zuulapigatewayserver;

import com.solidtech.zuulapigatewayserver.model.Role;
import com.solidtech.zuulapigatewayserver.service.RoleService;
import com.solidtech.zuulapigatewayserver.service.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayServerApplication.class, args);
	}

	@Bean
	CommandLineRunner initUsers(UserServiceImpl userService, RoleService roleService) {
		return args -> {

			System.out.println("I'm ARGS");

			if (roleService.findByName("USER") == null)
				roleService.save(new Role("USER", "Default role"));

			if (roleService.findByName("ADMIN") == null)
				roleService.save(new Role("ADMIN", "Admin role"));

			System.out.println("END ARGS");

		};

	}

}
