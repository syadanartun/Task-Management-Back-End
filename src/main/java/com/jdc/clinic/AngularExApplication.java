package com.jdc.clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdc.clinic.model.Role;
import com.jdc.clinic.model.Task;
import com.jdc.clinic.model.User;
import com.jdc.clinic.service.RoleService;
import com.jdc.clinic.service.TaskService;
import com.jdc.clinic.service.UserService;

@SpringBootApplication
public class AngularExApplication implements CommandLineRunner {
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(AngularExApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 1; i <= 5; i++) {
			taskService.saveTask(new Task("title " + i, "decision " + i));

		}
		Role adminRole = new Role("ADMIN");
		Role userRole = new Role("USER");

		roleService.saveRole(userRole);
		roleService.saveRole(adminRole);

		User adminUser = new User("admin", "admin");
		adminUser.getRole().add(adminRole);

		userService.saveUser(adminUser);

		for (int i = 0; i <= 3; i++) {
			User user = new User("username " + i, "user");
			user.getRole().add(userRole);
			userService.saveUser(user);
		}

	}

}
