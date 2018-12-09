/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookSubSystem;
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
public class bookDataMapper {
    
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> bookDb;
    private MongoCollection<Document> bookBorrowalDb;
    private Gson gson = new Gson();

    public bookDataMapper() {
        
         Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        client = new MongoClient();
        database = client.getDatabase("library"); 
        bookDb = database.getCollection("book"); 
        bookBorrowalDb = database.getCollection("bookBorrowal");
    }
    
    
    /*
    public void createConnection(){
    
    }
*/
    public void closeConnection(){
            client.close();
    }
    public ArrayList<book>retrieveAllBooks(){
        ArrayList<book> result = new ArrayList();
        ArrayList<Document> docs = bookDb.find().into(new ArrayList<Document>());
        
        for(int i=0;i<docs.size();i++){
        result.add(gson.fromJson(docs.get(i).toJson(), book.class));
        }
        
        return result;
    }
    
    public ArrayList<bookBorrowal>retrieveAllBorrowals(){
        ArrayList<bookBorrowal> result = new ArrayList();
        ArrayList<Document> docs = bookBorrowalDb.find().into(new ArrayList<Document>());
        for(int i=0;i<docs.size();i++){
           result.add(gson.fromJson(docs.get(i).toJson(),bookBorrowal.class));
    }
        return result;
    }
    public void addBook(book book){
    bookDb.insertOne(Document.parse(gson.toJson(book)));
    System.out.println("book inserted successfully");
    }
    public void updateBook(book book){
    
    }
    public void deleteBook(book book){
        boolean result = bookDb.deleteOne(Filters.eq("name", book.getName())).wasAcknowledged();
        if (result){
            System.out.println("book deleted successfully");
        }else{
            System.out.println("book was not found");
        }
        
    }
     public void deleteManyBook(String id){
        boolean result = bookDb.deleteMany(Filters.eq("id", id)).wasAcknowledged();
        if (result){
            System.out.println("book deleted successfully");
        }else{
            System.out.println("book was not found");
        }
        
    }
    public book retrieveBook(String bookName){
        Document doc = bookDb.find(Filters.eq("name", bookName)).first();
        book result = gson.fromJson(doc.toJson(), book.class);
        return result;
    }
    public void addBorrowal(bookBorrowal bookBorrowal){
    bookBorrowalDb.insertOne(Document.parse(gson.toJson((bookBorrowal))));
    System.out.println("book borrowal inserted succesfully");
    }
    public void updateBorrowal(bookBorrowal bookBorrowal){
    
    }
    public void deleteBorrowal(bookBorrowal bookBorrowal){
    boolean result = bookBorrowalDb.deleteOne(Filters.eq("borrowalNumber", bookBorrowal.getBorrowalNumber())).wasAcknowledged();
    if(result){
        System.out.println("borrowal record was deleted successfully");
    }
    else{
        System.err.println("borrowal record was not found");
    }
    }
    public bookBorrowal retrieveBorrowal(int borrowalNumber){
    
        Document doc = bookBorrowalDb.find(Filters.eq("borrowalNumber", borrowalNumber)).first();
        bookBorrowal result = gson.fromJson(doc.toJson(), bookBorrowal.class);
        return result;
    }
}
