/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import bookSubSystem.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.*;
import rminewserver.*;

/**
 *
 * @author Shehab
 */
public class test {
    public static void main(String[] args){
    //testbookdb();
    
     //testInventory();
     //testborrowaldb();
        System.out.println("_______________________");
     // testcontrol();
     testallborrowed();
     //deleteborrowal();
     
    }
    public static void deleteborrowal(){
    bookDataMapper dm = new bookDataMapper();
    dm.deleteManyBook("5");
    }
    public static void testallborrowed(){
        try {
            bookRemoteFacade fd = new bookRemoteFacade();
            System.out.println(fd.getAllBorrowedBooks("12"));
        } catch (RemoteException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void testInventory(){
    bookInventory inv = new bookInventory();
    inv.displayAllBooks();
    }
    public static void testborrowaldb(){
    
        
    bookDataMapper db = new bookDataMapper();
    bookInventory inv = new bookInventory();
    bookBorrowal b1 = new bookBorrowal(5,"na","na","na",12.5,"33","12",true);
    bookBorrowal b2 = new bookBorrowal(12,"na","na","na",50.5,"2","13",false);
    bookBorrowal b3 = new bookBorrowal(15,"na","na","na",12.5,"7","12",true);

   //db.addBorrowal(b1);
   //db.addBorrowal(b2);
   inv.addBorrowal(b3);
   inv.addBorrowal(b2);
   ArrayList<bookBorrowal> result = new ArrayList();
   result = db.retrieveAllBorrowals();
   for(int i=0;i<result.size();i++){
       System.out.println(result.get(i).getBorrowalNumber()+" : "+result.get(i).getBookId());
   }
    db.closeConnection();
    }
    
    
    
    public static void testcontrol(){
        try {
            bookRemoteFacade b = new bookRemoteFacade();
            boolean result = b.findBookByName("pride and prejudice");
            if(result==true){
                System.out.println("book found!!!!!");
            }
            if(result==false){
             //   System.out.println("book not found");
            }
           // b.getAllBooks();
        } catch (RemoteException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    
    public static void testbookdb(){
    
     bookDataMapper db = new bookDataMapper();
        bookInventory inv = new bookInventory();
        book book1 = new book("el7alazona","dewan","151324","sama7",5,7);
        book book2 = new book("pride and prejudice","novel","1","jane austin",5,13);
        book book3 = new book("testing","test","book","me",6,17);
        //db.addBook(book1);
        //db.addBook(book2);
        inv.addBook(book3);
        
        ArrayList<book> result = new ArrayList();
        //result = db.retrieveAllBooks();
        result = inv.retrieveAllBooks();
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i).getName());
        }
        db.closeConnection();
    }
    
    
}
