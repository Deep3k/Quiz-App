package com.deep.Quiz.controller;

import com.deep.Quiz.dto.LoginRequest;
import com.deep.Quiz.entity.QuizQuestion;
import com.deep.Quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    QuestionService questionService;

    private final String username = "user";
    private final String password = "password";

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
       if(username.equals(loginRequest.getUsername()) && password.equals(loginRequest.getPassword())){
           return "Login Successful!";
       }
       else{
           return "Invalid username or password";
       }
    }

    @GetMapping("/questions")
    public List<QuizQuestion> getQuestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping(value = "/save" , consumes = "application/json" , produces="application/json")
    public QuizQuestion saveQuestion(@RequestBody QuizQuestion question)
    {
        return questionService.saveQuestion(question);
    }



}
