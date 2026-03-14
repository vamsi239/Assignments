package com.lpu.account.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.account.entity.Account;
import com.lpu.account.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepository repo;

    @PostMapping("/save")
    public Account save(@RequestBody Account acc) {
        return repo.save(acc);
    }

    @GetMapping("/findAll")
    public List<Account> findAll(){
        return repo.findAll();
    }

    @GetMapping("/find/{id}")
    public Account findById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }
}