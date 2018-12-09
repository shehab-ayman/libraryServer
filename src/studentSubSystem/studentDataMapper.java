/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentSubSystem;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
/**
 *
 * @author Shehab
 */
public class studentDataMapper {
    
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> studentDb;
    private Gson gson = new Gson();

    public studentDataMapper() {
        
         Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        client = new MongoClient();
        database = client.getDatabase("library"); 
        studentDb = database.getCollection("student"); 
     
    }
    
    
    /*
    public void createConnection(){
    
    }
*/
    public void closeConnection(){
            client.close();
    }
    
    public ArrayList<student>retrieveAllStudents(){
        ArrayList<student> result = new ArrayList();
        ArrayList<Document> docs = studentDb.find().into(new ArrayList<Document>());
        
        for(int i=0;i<docs.size();i++){
        result.add(gson.fromJson(docs.get(i).toJson(), student.class));
        }
        return result;
    }
   
    public void addStudent(student stud){
        
   // boolean result = studentDb.find(Filters.eq("username", stud.username));
    studentDb.insertOne(Document.parse(gson.toJson(stud)));
    System.out.println("student inserted successfully");
    }
    
   
    
    public void deleteStudent(student stud){
        boolean result = studentDb.deleteOne(Filters.eq("id", stud.getId())).wasAcknowledged();
        if (result)
        {
            System.out.println("Student deleted successfully");
        }
        else
        {
            System.out.println("Student was not found");
        }
        
    }
     public void updateStudent(student stud)
    {
        boolean result = studentDb.deleteOne(Filters.eq("id", stud.getId())).wasAcknowledged();
        if (!result)
        {
            System.out.println("Student was not found");
        }
        studentDb.insertOne(Document.parse(gson.toJson(stud)));
        System.out.println("student updated successfully");
        
    }
    public student retrieveStudent(String studentId){
        Document doc = studentDb.find(Filters.eq("id", studentId)).first();
        student result = gson.fromJson(doc.toJson(), student.class);
        return result;
    }
    
    public boolean logIn(String username, String password)
    { ArrayList<student> result = new ArrayList();
        ArrayList<Document> docs = studentDb.find().into(new ArrayList<Document>());
        
        for(int i=0;i<docs.size();i++){
        result.add(gson.fromJson(docs.get(i).toJson(), student.class));
         if(result.get(i).getUsername().equals(username)&&result.get(i).getPassword().equals(password))
         {return true;}
        
        }
        return false;
    }
    
}
