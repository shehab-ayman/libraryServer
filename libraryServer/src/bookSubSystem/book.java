/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookSubSystem;
import java.util.Random;

/**
 *
 * @author Shehab
 */
public class book {
    public String name;
    public String type;
    public String id;
    public String author;
    public int availableCopies;
    public int totalCopies;

    public book() {
    }

    public book(String name, String type, String id, String author, int availableCopies, int totalCopies) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.author = author;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
    }
    
    
    public void displayBookInfo(){
        
    String info = name+","+type+","+id+","+author+","+String.valueOf(availableCopies)+","+String.valueOf(totalCopies); 
        System.out.println(info);
    }
    public void borrowBook(String studentId){
        Random rand = new Random();
        bookBorrowal borrow = new bookBorrowal(rand.nextInt(500)+1,"na","na","na",0.0,this.id,studentId,true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }
    
    
}
