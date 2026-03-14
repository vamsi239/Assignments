package com.lpu.users.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.users.entity.Users;
import com.lpu.users.service.UsersService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UsersService us;
	
	@PostMapping("/save")
	public Users saveusers(@RequestBody Users user){
		return us.saveUsers(user);
		
	}

	@GetMapping("find/{id}")
	public Users findbyid(@PathVariable int id) {
		return us.findUsers(id);
	}
	

}
