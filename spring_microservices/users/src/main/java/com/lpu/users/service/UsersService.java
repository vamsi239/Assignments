package com.lpu.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.users.entity.Users;
import com.lpu.users.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repo;
	
	  public Users saveUsers(Users users) {
		    return repo.save(users);
	  }
	  
	  public Users findUsers(int id) {
		     return repo.findById(id).orElseThrow(()->new IllegalArgumentException("not found"));
	  }
}
