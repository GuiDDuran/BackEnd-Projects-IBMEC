package com.helloworld.spring.helloworld.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<String> saudacao(@RequestParam("nome") String nome, @RequestParam("idade") Integer idade){
        if (nome == ""){
            return new ResponseEntity<>("Hello World!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hello World, " + nome + ", você tem " + idade + " anos.", HttpStatus.OK);
    }
}
