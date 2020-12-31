package com.fbla.dbconnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fbla.objects.CapitalsObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;  

@Component
public class MongoDBConnection {

    @Value("${mongo.db.url}")
    private String mongodbURL;
    @Value("${mongo.db.port}")
    private int mongodbPort;
    @Value("${mongo.db.name}")
    private String dbName;
    @Value("${mongo.db.table.name}")
    private String tableName;
    
  
    
    public  ArrayList< String> getRandomFactOfTheDay(){
    	
    	 MongoClientURI uri = new MongoClientURI(

				    "mongodb://admin:admin@cluster0-shard-00-00.xzlij.mongodb.net:27017,cluster0-shard-00-01.xzlij.mongodb.net:27017,cluster0-shard-00-02.xzlij.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-s18vg0-shard-0&authSource=admin&retryWrites=true&w=majority");



				MongoClient mongoClient = new MongoClient(uri);


				
				MongoDatabase database = mongoClient.getDatabase("geobeedb");
        
          MongoCollection<Document> collection = database.getCollection("us_state_facts");
       // MongoCollection<Document> collection = database.getCollection("capit");

        List<Document> results = new ArrayList();
       // Document CapitalQuery = new Document("questionType", "Capitals");
       Document funFactQuery = new Document();
        collection.find(funFactQuery).into(results);
   //   System.out.println("results-->"+results.size());

      ArrayList< String> funFactList = new ArrayList< String>();
//        List<MultipleChoiceObject> questionList= new ArrayList();
       for(int i=0;i<results.size();i++) {
        Document multipleChoiceDocument = results.get(i);

      
        
      
        String funFact=multipleChoiceDocument.getString("Fun_Fact");
      
    	
        funFactList.add( funFact);
    	
       }
        

        return funFactList;
    }
    
    
    public  ArrayList< CapitalsObject> getFlagsQuestions(){
        
        
		 MongoClientURI uri = new MongoClientURI(

				    "mongodb://admin:admin@cluster0-shard-00-00.xzlij.mongodb.net:27017,cluster0-shard-00-01.xzlij.mongodb.net:27017,cluster0-shard-00-02.xzlij.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-s18vg0-shard-0&authSource=admin&retryWrites=true&w=majority");



				MongoClient mongoClient = new MongoClient(uri);

 
				
MongoDatabase database = mongoClient.getDatabase("geobeedb");
MongoCollection<Document> collection = database.getCollection("us_states_flags");
// MongoCollection<Document> collection = database.getCollection("capit");

List<Document> results = new ArrayList();
Document CapitalQuery = new Document("questionSubType", "Flags");
// Document CapitalQuery = new Document();
collection.find(CapitalQuery).into(results);
//System.out.println("results-->"+results.size());

ArrayList< CapitalsObject> capitalArrayList = new ArrayList< CapitalsObject>();
//List<MultipleChoiceObject> questionList= new ArrayList();
for(int i=0;i<results.size();i++) {
Document multipleChoiceDocument = results.get(i);



CapitalsObject capitalsObject = new CapitalsObject();
capitalsObject.setQuestionId(multipleChoiceDocument.getInteger("questionId"));
capitalsObject.setQuestion(multipleChoiceDocument.getString("question"));
//System.out.println(multipleChoiceDocument.getString("question"));
//multipleChoiceObject.questionNumber
capitalsObject.setChoice1(multipleChoiceDocument.getString("Option1"));
capitalsObject.setChoice2(multipleChoiceDocument.getString("Option2"));
capitalsObject.setChoice3(multipleChoiceDocument.getString("Option3"));
capitalsObject.setChoice4(multipleChoiceDocument.getString("Option4"));
capitalsObject.setAnswer(multipleChoiceDocument.getString("Answer"));
if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice1())) {
	capitalsObject.setAnswerOption("itemOne");
	
}
else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice2())) {
	capitalsObject.setAnswerOption("itemTwo");
	
}
else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice3())) {
	capitalsObject.setAnswerOption("itemThree");
	
}
else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice4())) {
	capitalsObject.setAnswerOption("itemFour");
	
}
capitalsObject.setQuestionType(multipleChoiceDocument.getString("questionType"));
capitalsObject.setQuestionSubType(multipleChoiceDocument.getString("questionSubType"));

capitalArrayList.add( capitalsObject);

}


return capitalArrayList;
}
    
public  ArrayList< CapitalsObject> getCapitalsQuestions(){
    
    
			 MongoClientURI uri = new MongoClientURI(

					    "mongodb://admin:admin@cluster0-shard-00-00.xzlij.mongodb.net:27017,cluster0-shard-00-01.xzlij.mongodb.net:27017,cluster0-shard-00-02.xzlij.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-s18vg0-shard-0&authSource=admin&retryWrites=true&w=majority");



					MongoClient mongoClient = new MongoClient(uri);

	  
					
    MongoDatabase database = mongoClient.getDatabase("geobeedb");
    MongoCollection<Document> collection = database.getCollection("us_state_capitals");
   // MongoCollection<Document> collection = database.getCollection("capit");

    List<Document> results = new ArrayList();
    Document CapitalQuery = new Document("questionType", "Capitals");
   // Document CapitalQuery = new Document();
    collection.find(CapitalQuery).into(results);
  //System.out.println("results-->"+results.size());

  ArrayList< CapitalsObject> capitalArrayList = new ArrayList< CapitalsObject>();
//    List<MultipleChoiceObject> questionList= new ArrayList();
   for(int i=0;i<results.size();i++) {
    Document multipleChoiceDocument = results.get(i);

  
    
    CapitalsObject capitalsObject = new CapitalsObject();
    capitalsObject.setQuestionId2(multipleChoiceDocument.getString("questionId"));
    capitalsObject.setQuestion(multipleChoiceDocument.getString("question"));
//    System.out.println(multipleChoiceDocument.getString("question"));
//	multipleChoiceObject.questionNumber
    capitalsObject.setChoice1(multipleChoiceDocument.getString("choice1"));
    capitalsObject.setChoice2(multipleChoiceDocument.getString("choice2"));
    capitalsObject.setChoice3(multipleChoiceDocument.getString("choice3"));
    capitalsObject.setChoice4(multipleChoiceDocument.getString("choice4"));
    capitalsObject.setAnswer(multipleChoiceDocument.getString("answer"));
	if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice1())) {
		capitalsObject.setAnswerOption("itemOne");
		
	}
	else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice2())) {
		capitalsObject.setAnswerOption("itemTwo");
		
	}
	else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice3())) {
		capitalsObject.setAnswerOption("itemThree");
		
	}
	else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice4())) {
		capitalsObject.setAnswerOption("itemFour");
		
	}
	capitalsObject.setQuestionType(multipleChoiceDocument.getString("questionType"));
	capitalsObject.setQuestionSubType(multipleChoiceDocument.getString("questionSubType"));
	
	capitalArrayList.add( capitalsObject);
	
   }
    

    return capitalArrayList;
}

public  ArrayList< CapitalsObject> getMiscQuestions(){
    
    
	 MongoClientURI uri = new MongoClientURI(

			    "mongodb://admin:admin@cluster0-shard-00-00.xzlij.mongodb.net:27017,cluster0-shard-00-01.xzlij.mongodb.net:27017,cluster0-shard-00-02.xzlij.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-s18vg0-shard-0&authSource=admin&retryWrites=true&w=majority");



			MongoClient mongoClient = new MongoClient(uri);


			
MongoDatabase database = mongoClient.getDatabase("geobeedb");
MongoCollection<Document> collection = database.getCollection("us_state_Misc");
//MongoCollection<Document> collection = database.getCollection("capit");

List<Document> results = new ArrayList();
Document nicknameQuery = new Document("questionType", "General");
//Document CapitalQuery = new Document();
collection.find(nicknameQuery).into(results);
//System.out.println("results-->"+results.size());

ArrayList< CapitalsObject> nicknameArrayList = new ArrayList< CapitalsObject>();
//List<MultipleChoiceObject> questionList= new ArrayList();
for(int i=0;i<results.size();i++) {
Document multipleChoiceDocument = results.get(i);



CapitalsObject capitalsObject = new CapitalsObject();
capitalsObject.setQuestion(multipleChoiceDocument.getString("Question"));
//System.out.println(multipleChoiceDocument.getString("Question"));
//multipleChoiceObject.questionNumber
capitalsObject.setChoice1(multipleChoiceDocument.getString("Option1"));
capitalsObject.setChoice2(multipleChoiceDocument.getString("Option2"));
capitalsObject.setChoice3(multipleChoiceDocument.getString("Option3"));
capitalsObject.setChoice4(multipleChoiceDocument.getString("Option4"));
capitalsObject.setAnswer(multipleChoiceDocument.getString("Answer"));
if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice1())) {
capitalsObject.setAnswerOption("itemOne");

}
else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice2())) {
capitalsObject.setAnswerOption("itemTwo");

}
else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice3())) {
capitalsObject.setAnswerOption("itemThree");

}
else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice4())) {
capitalsObject.setAnswerOption("itemFour");

}
capitalsObject.setQuestionType(multipleChoiceDocument.getString("questionType"));
capitalsObject.setQuestionSubType(multipleChoiceDocument.getString("questionSubType"));

nicknameArrayList.add( capitalsObject);

}


return nicknameArrayList;
}

public  ArrayList< CapitalsObject> getNicknamesQuestions(){
    
    
	 MongoClientURI uri = new MongoClientURI(

			    "mongodb://admin:admin@cluster0-shard-00-00.xzlij.mongodb.net:27017,cluster0-shard-00-01.xzlij.mongodb.net:27017,cluster0-shard-00-02.xzlij.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-s18vg0-shard-0&authSource=admin&retryWrites=true&w=majority");



			MongoClient mongoClient = new MongoClient(uri);


			
MongoDatabase database = mongoClient.getDatabase("geobeedb");
MongoCollection<Document> collection = database.getCollection("us_state_Nick_Names");
// MongoCollection<Document> collection = database.getCollection("capit");

List<Document> results = new ArrayList();
Document nicknameQuery = new Document("questionType", "NickNames");
// Document CapitalQuery = new Document();
collection.find(nicknameQuery).into(results);
//System.out.println("results-->"+results.size());

ArrayList< CapitalsObject> nicknameArrayList = new ArrayList< CapitalsObject>();
//List<MultipleChoiceObject> questionList= new ArrayList();
for(int i=0;i<results.size();i++) {
Document multipleChoiceDocument = results.get(i);



CapitalsObject capitalsObject = new CapitalsObject();
capitalsObject.setQuestionId(multipleChoiceDocument.getInteger("questionId"));
capitalsObject.setQuestion(multipleChoiceDocument.getString("Question"));
System.out.println(multipleChoiceDocument.getString("Question"));
//multipleChoiceObject.questionNumber
capitalsObject.setChoice1(multipleChoiceDocument.getString("Option1"));
capitalsObject.setChoice2(multipleChoiceDocument.getString("Option2"));
capitalsObject.setChoice3(multipleChoiceDocument.getString("Option3"));
capitalsObject.setChoice4(multipleChoiceDocument.getString("Option4"));
capitalsObject.setAnswer(multipleChoiceDocument.getString("Answer"));
if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice1())) {
capitalsObject.setAnswerOption("itemOne");

}
else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice2())) {
capitalsObject.setAnswerOption("itemTwo");

}
else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice3())) {
capitalsObject.setAnswerOption("itemThree");

}
else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice4())) {
capitalsObject.setAnswerOption("itemFour");

}
capitalsObject.setQuestionType(multipleChoiceDocument.getString("questionType"));
capitalsObject.setQuestionSubType(multipleChoiceDocument.getString("questionSubType"));

nicknameArrayList.add( capitalsObject);

}


return nicknameArrayList;
}

public  ArrayList< CapitalsObject> getQuestionsByState( int size){
	ArrayList<CapitalsObject> CapitaArrayList= new ArrayList< CapitalsObject>();
int k =0;
/*String [] stateArray = {"Alabama",
		"Alaska",
		"Arizona",
		"Arkansas",
		"California",
		"Colorado",
		"Connecticut",
		"Delaware",
		"Florida",
		"Georgia",
		"Hawaii",
		"Idaho",
		"Illinois",
		"Indiana",
		"Iowa",
		"Kansas",
		"Kentucky",
		"Louisiana",
		"Maine",
		"Maryland",
		"Massachusetts",
		"Michigan",
		"Minnesota",
		"Mississippi",
		"Missouri",
		"Montana",
		"Nebraska",
		"Nevada",
		"New Hampshire",
		"New_Jersey",
		"New_Mexico",
		"New_York",
		"North_Carolina",
		"North_Dakota",
		"Ohio",
		"Oklahoma",
		"Oregon",
		"Pennsylvania",
		"Rhode_Island",
		"South_Carolina",
		"South_Dakota",
		"Tennessee",
		"Texas",
		"Utah",
		"Vermont",
		"Virginia",
		"Washington",
		"West_Virginia",
		"Wisconsin",
		"Wyoming"};*/

String [] stateArray = {"North_Dakota"};


for (int i =0; i < stateArray.length; i++)  {
	 MongoClientURI uri = new MongoClientURI(

			    "mongodb://admin:admin@cluster0-shard-00-00.xzlij.mongodb.net:27017,cluster0-shard-00-01.xzlij.mongodb.net:27017,cluster0-shard-00-02.xzlij.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-s18vg0-shard-0&authSource=admin&retryWrites=true&w=majority");



			MongoClient mongoClient = new MongoClient(uri);

    MongoDatabase database = mongoClient.getDatabase("geobeedb");
   // System.out.println("stateName-->"+ stateArray[i]);
    MongoCollection<Document> collection = null;
    if(stateArray[i] != null) {
     collection = database.getCollection("us_state_" + stateArray[i]);
    }
    // MongoCollection<Document> collection = database.getCollection("capit");

    List<Document> results = new ArrayList();
    Document CapitalQuery = new Document("questionSubType", stateArray[i]);
   // Document CapitalQuery = new Document();
    collection.find(CapitalQuery).into(results);
    System.out.println("results-->"+results.size());

//    List<MultipleChoiceObject> questionList= new ArrayList();
   for(int j=0; j<results.size();j++) {
    Document multipleChoiceDocument = results.get(j);

 
    CapitalsObject capitalsObject = new CapitalsObject();
    capitalsObject.setQuestionId(multipleChoiceDocument.getInteger("questionId"));
    capitalsObject.setQuestion(multipleChoiceDocument.getString("Question"));
//    System.out.println(multipleChoiceDocument.getString("Question"));
    
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4); 
//    System.out.println("list before shuffling : " + numbers); 
    Collections.shuffle(numbers);
    //System.out.println("list after shuffling : " + numbers);
    
   
    
//	multipleChoiceObject.questionNumber
    capitalsObject.setChoice1(multipleChoiceDocument.getString("Option"+numbers.get(0)));
    capitalsObject.setChoice2(multipleChoiceDocument.getString("Option"+numbers.get(1)));
    capitalsObject.setChoice3(multipleChoiceDocument.getString("Option"+numbers.get(2)));
    capitalsObject.setChoice4(multipleChoiceDocument.getString("Option"+numbers.get(3)));
    capitalsObject.setAnswer(multipleChoiceDocument.getString("Answer"));
    
	if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice1())) {
		capitalsObject.setAnswerOption("itemOne");
		
	}
	else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice2())) {
		capitalsObject.setAnswerOption("itemTwo");
		
	}
	else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice3())) {
		capitalsObject.setAnswerOption("itemThree");
		
	}
	else if(capitalsObject.getAnswer()!=null && capitalsObject.getAnswer().equalsIgnoreCase(capitalsObject.getChoice4())) {
		capitalsObject.setAnswerOption("itemFour");
		
	}
	capitalsObject.setQuestionType(multipleChoiceDocument.getString("questionType"));
	capitalsObject.setQuestionSubType(multipleChoiceDocument.getString("questionSubType"));
	
	
	CapitaArrayList.add( capitalsObject);
	
}
    

}
	if (CapitaArrayList.size() < size) {
		ArrayList<CapitalsObject> CapitalArrayList= new ArrayList< CapitalsObject>();
		return CapitalArrayList;
	}
	else {
    return CapitaArrayList;
	}
}
}



