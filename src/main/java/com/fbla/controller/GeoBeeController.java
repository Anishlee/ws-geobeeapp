package com.fbla.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fbla.dbconnection.MongoDBConnection;
import com.fbla.objects.CapitalsObject;
import com.fbla.objects.User;
import com.fbla.objects.UserObject;
import com.geobee.helper.GeobeeHelper;



@RestController
@RequestMapping("/geobee")
public class GeoBeeController {
	
	static ArrayList< CapitalsObject> capitalQuestionsArrayList = null; 
	static ArrayList< CapitalsObject> miscQuestionsArrayList = null; 
	static ArrayList< CapitalsObject> flagsQuestionsArrayList = null; 
	static ArrayList< CapitalsObject> geoBeeQuestionsByStateArrayList = null; 
	static ArrayList< CapitalsObject> nickNameQuestionsArrayList = null; 
	static ArrayList< String> randomFactOfTheDayArrayList = null; 
	static HashMap<String, UserObject> userSavedSession=new HashMap<String, UserObject>();
    
	 @GetMapping(value = "/getCapitalQuestionsTest")
	    public String getCapitalQuestionsTest(@RequestParam(name ="size") int size){
	    	
	    return "Hello World";	
	        
	    }
	    
    
    
    @GetMapping(value = "/getCapitalQuestions")
    public ArrayList<CapitalsObject> getCapitalQuestions(@RequestParam(name ="size") int size){
    	
    	if(capitalQuestionsArrayList==null || capitalQuestionsArrayList.size()==0) {
    	
    	MongoDBConnection mongoDBConnection = new MongoDBConnection();
    	capitalQuestionsArrayList = new ArrayList< CapitalsObject>();
    	capitalQuestionsArrayList=mongoDBConnection.getCapitalsQuestions();
    
    	

    
    	}
    	GeobeeHelper geobeeHelper = new GeobeeHelper();
    	
    	ArrayList<CapitalsObject> capitalQuestionsArray=geobeeHelper.getRandomCapitalsQuestions(capitalQuestionsArrayList,size);
    	
        return capitalQuestionsArray;
        
    }
    
    
    @GetMapping(value = "/getFlagsQuestions")
    public ArrayList<CapitalsObject> getFlagsQuestions(@RequestParam(name ="size") int size){
    	
	if(flagsQuestionsArrayList==null || flagsQuestionsArrayList.size()==0) {
        	
        	MongoDBConnection mongoDBConnection = new MongoDBConnection();
        	flagsQuestionsArrayList = new ArrayList< CapitalsObject>();
        	flagsQuestionsArrayList=mongoDBConnection.getFlagsQuestions();
        
        	

        
        	}
    	
    	
    	

    	GeobeeHelper geobeeHelper = new GeobeeHelper();
    	
    ArrayList	capitalList=geobeeHelper.getRandomCapitalsQuestions(flagsQuestionsArrayList,size);
        return capitalList;
        
    }
    
    @GetMapping(value = "/getNicknamesQuestions")
    public ArrayList<CapitalsObject> getNicknamesQuestions(@RequestParam(name ="size") int size){
    	
    	if(nickNameQuestionsArrayList==null || nickNameQuestionsArrayList.size()==0) {
        	
        	MongoDBConnection mongoDBConnection = new MongoDBConnection();
        	nickNameQuestionsArrayList = new ArrayList< CapitalsObject>();
        	nickNameQuestionsArrayList=mongoDBConnection.getNicknamesQuestions();
        
        	

        
        	}
    	
    	
    	

    	GeobeeHelper geobeeHelper = new GeobeeHelper();
    	
    ArrayList	capitalList=geobeeHelper.getRandomCapitalsQuestions(nickNameQuestionsArrayList,size);
        return capitalList;
        
    }
    
    @GetMapping(value = "/getMiscQuestions")
    public ArrayList<CapitalsObject> getMiscQuestions(@RequestParam(name ="size") int size){
    	
    	if(miscQuestionsArrayList==null || miscQuestionsArrayList.size()==0) {
        	
        	MongoDBConnection mongoDBConnection = new MongoDBConnection();
        	miscQuestionsArrayList = new ArrayList< CapitalsObject>();
        	miscQuestionsArrayList=mongoDBConnection.getMiscQuestions();
        
        	

        
        	}
    	
    
    	

    	GeobeeHelper geobeeHelper = new GeobeeHelper();
    	
    ArrayList	capitalList=geobeeHelper.getRandomCapitalsQuestions(miscQuestionsArrayList,size);
        return capitalList;
        
    }
    
    
    @PostMapping(value="/saveUserSession")

    public void saveUserSession(@RequestBody UserObject userObject) {
    	System.out.println("In save usersession1");
    	User user= userObject.getUser();
    
    	System.out.println("user"+user.getEmail());
    	System.out.println("user"+userObject);
    	
  
    	
    	
    	if(userObject!=null) {
    		
    		userSavedSession.put(user.getEmail(), userObject);
    	}
    	
       
    	
    }
    
    @GetMapping(value = "/getUserSavedSession")

    public UserObject  getUserSavedSession(@RequestParam(name ="email") String email) {
    	System.out.println("In save usersession2");
    	UserObject userObject= userSavedSession.get(email);
    
    	
    	
    return userObject;
       
    	
    }
    
    @PostMapping(value = "/resetUserSavedSession")

    public void  resetUserSavedSession(@RequestBody User user) {
    	
    	
    	
    	userSavedSession.remove(user.getEmail());
    	System.out.println("existing session"+userSavedSession.get(user.getEmail()));
    	
    	
    
       
    	
    }
    

    @GetMapping(value = "/getQuestionsByState")
    public ArrayList<CapitalsObject> getQuestionsByState(@RequestParam(name ="size") int size){
    	
    	
    	
    		if(geoBeeQuestionsByStateArrayList==null || geoBeeQuestionsByStateArrayList.size()==0) {
        	
        	MongoDBConnection mongoDBConnection = new MongoDBConnection();
        	geoBeeQuestionsByStateArrayList = new ArrayList< CapitalsObject>();
        	geoBeeQuestionsByStateArrayList=mongoDBConnection.getQuestionsByState(size);
        
        	

        
        	}
    	
   


    	GeobeeHelper geobeeHelper = new GeobeeHelper();
    if (geoBeeQuestionsByStateArrayList.size() == 0	) {
    	ArrayList<CapitalsObject> CapitaArrayList= new ArrayList< CapitalsObject>();
    	return CapitaArrayList;
    }
    else {
    ArrayList	capitalList=geobeeHelper.getRandomCapitalsQuestions(geoBeeQuestionsByStateArrayList,size);
        return capitalList;
    }
        
    }
    

    @GetMapping(value = "/getRandomFactOfTheDay")
    public ArrayList<String> getRandomFactOfTheDay(){
    	
    	
    	GeobeeHelper geobeeHelper = new GeobeeHelper();
    	
    	
        
        
        if(randomFactOfTheDayArrayList==null || randomFactOfTheDayArrayList.size()==0) {
        	
          	MongoDBConnection mongoDBConnection = new MongoDBConnection();
        	
       	  randomFactOfTheDayArrayList=mongoDBConnection.getRandomFactOfTheDay();
       	
        
        	}
        
        	
        	ArrayList	capitalList=geobeeHelper.getRandomFunFactQuestions(randomFactOfTheDayArrayList,1);
            return capitalList;
        
    }
    
}