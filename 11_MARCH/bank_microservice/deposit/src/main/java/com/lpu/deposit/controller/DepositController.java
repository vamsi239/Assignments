package com.lpu.deposit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.lpu.deposit.feign.AccountFeign;
import com.lpu.deposit.model.Account;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    AccountFeign accountFeign;

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable int id){
        return accountFeign.getAccountById(id);
    }

    @GetMapping("/allAccounts")
    public List<Account> getAllAccounts1(){
        return accountFeign.getAllAccounts();
    }
    
    
    @PostMapping("/saveAccount")
    public String saveAccount(@RequestBody Account account){
        return accountFeign.saveAccount(account);
    }
    

//    @GetMapping("/account/{id}")
//    public ResponseEntity<String> getAccount(@PathVariable Long id) {
//
//        String url = "http://localhost:8083/account/find/" + id;
//
//        ResponseEntity<String> response =
//                restTemplate.getForEntity(url, String.class);
//
//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
    
//    @GetMapping("/account/{id}")
//	public ResponseEntity<String> findpayment(@PathVariable int id) {
//		String url ="http://localhost:8083/account/find/{id}";
//		RestTemplate template = new RestTemplate();
//		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class,id);
//	  return response;
//	}
//    
//    @GetMapping("/allAccounts")
//    public ResponseEntity<String> getAllAccounts() {
//
//        String url = "http://localhost:8083/account/findAll";
//
//        RestTemplate template = new RestTemplate();
//
//        ResponseEntity<String> response =
//                template.exchange(url, HttpMethod.GET, null, String.class);
//
//        return response;
//    }

//    @GetMapping("/allAccounts")
//    public ResponseEntity<String> getAllAccounts() {
//
//        String url = "http://localhost:8083/account/findAll";
//
//        ResponseEntity<String> response =
//                restTemplate.getForEntity(url, String.class);
//        
//        return response;

//        return ResponseEntity
//                .status(response.getStatusCode())
//                .body(response.getBody());
//    }
}