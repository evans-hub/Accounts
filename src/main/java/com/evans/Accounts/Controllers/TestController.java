package com.evans.Accounts.Controllers;

import com.evans.Accounts.Entities.Country;
import com.evans.Accounts.Repos.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestRepository testRepository;
    @GetMapping("/")
    public String returnString(){
        return "hello nice work";
    }
    @PostMapping("/insert")
    public ResponseEntity<Country> insertCountry(@RequestBody Country country){
        return ResponseEntity.ok().body(testRepository.save(country));
    }
    @GetMapping("/insert")
    public  ResponseEntity<List<Country>> getCountry(){
        return ResponseEntity.ok().body(testRepository.findAll());
    }
}
