package com.fbla.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbla.dbconnection.MongoDBConnection;

@RestController
@RequestMapping("/fbla")
public class FBLAQuizController {
    
  
   
    
    @GetMapping(value = "/getRandomQuizQuestions")
    public HashMap getRandomQuizQuestions(){
    	HashMap  multipleChoiceHashMap = new HashMap();
    	
		
        return multipleChoiceHashMap;
        
    }
    
    
}

