package com.lpu.deposit.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.lpu.deposit.model.Account;

@FeignClient(name="account", path="/account")
public interface AccountFeign {

    @GetMapping("/find/{id}")
    Account getAccountById(@PathVariable int id);

    @GetMapping("/findAll")
    List<Account> getAllAccounts();
    
    @PostMapping("/save")
    String saveAccount(@RequestBody Account account);

}





