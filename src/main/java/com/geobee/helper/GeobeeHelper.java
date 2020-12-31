package com.geobee.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import com.fbla.objects.CapitalsObject;

public class GeobeeHelper {
	
	
	 public ArrayList getRandomCapitalsQuestions(ArrayList< CapitalsObject> capitalArrayList, int size){
	        
	    	Random randomTrueandFalse = new Random();
	        
	         Set set = new LinkedHashSet();
		   int x=0;
		   System.out.println(size);
	         while (x < size) {
	            set.add(randomTrueandFalse.nextInt(capitalArrayList.size()));
	            x=set.size();
	         }
	    
	  //       System.out.println("Random numbers with no duplicates = "+set);
			
	         ArrayList<CapitalsObject> randomCapitalsList = new ArrayList< CapitalsObject>();
	         
	         // Creating an iterator 
	         Iterator value = set.iterator(); 
	   
	         // Displaying the values after iterating through the iterator 
	  //       System.out.println("The iterator values are: "); 
	         while (value.hasNext()) { 
	            int key=(int)value.next();
	            randomCapitalsList.add( capitalArrayList.get(key));
	         } 
	         
	         
	        return randomCapitalsList;
	        
	    

}
	 
	 public ArrayList getRandomFunFactQuestions(ArrayList< String> funFactList, int size){
	        
	    	Random randomTrueandFalse = new Random();
	        
	         Set set = new LinkedHashSet();
		   int x=0;
		   System.out.println(size);
	         while (x < size) {
	            set.add(randomTrueandFalse.nextInt(funFactList.size()));
	            x=set.size();
	         }
	    
	         System.out.println("Random numbers with no duplicates = "+set);
			
	         ArrayList<String> randomCapitalsList = new ArrayList< String>();
	         
	         // Creating an iterator 
	         Iterator value = set.iterator(); 
	   
	         // Displaying the values after iterating through the iterator 
	         System.out.println("The iterator values are: "); 
	         while (value.hasNext()) { 
	            int key=(int)value.next();
	            randomCapitalsList.add( funFactList.get(key));
	         } 
	         
	         
	        return randomCapitalsList;
	        
	    

}
}
