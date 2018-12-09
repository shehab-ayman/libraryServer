/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminSubSystem;
import bookSubSystem.book;
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
 * @author User
 */
public class adminDataMapper {
        private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> adminDb;
    private Gson gson = new Gson();
    
    public adminDataMapper() {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        client = new MongoClient();
        database = client.getDatabase("library"); 
        adminDb = database.getCollection("admin"); 
    }
    public void closeConnection(){
            client.close();
    }
        public void addAdmin(admin admin){
    adminDb.insertOne(Document.parse(gson.toJson(admin)));
    System.out.println("admin inserted successfully");
    }
            public void deleteAdmin(admin admin){
        boolean result = adminDb.deleteOne(Filters.eq("adminName", admin.getAdminName())).wasAcknowledged();
        if (result){
            System.out.println("admin deleted successfully");
        }else{
            System.out.println("admin was not found");
        }
        
    }
    public void updateAdmin(admin admin){
    
    }

  /*  public admin retrieveAllAdmins(String adminName){
        Document doc = adminDb.find(Filters.eq("adminName", adminName)).first();
        admin result = gson.fromJson(doc.toJson(), admin.class);
        return result;
    } */
    
        public ArrayList<admin>retrieveAllAdmins(){
        ArrayList<admin> result = new ArrayList();
        ArrayList<Document> docs = adminDb.find().into(new ArrayList<Document>());
        for(int i=0;i<docs.size();i++){
           result.add(gson.fromJson(docs.get(i).toJson(),admin.class));
    }
        return result;
    }
}
