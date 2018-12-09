/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import bookSubSystem.*;
import java.util.Random;
import javax.swing.JOptionPane;



/**
 *
 * @author Shehab
 */
public class bookRemoteFacade extends UnicastRemoteObject implements bookRemoteFacadeInterface {

    public bookRemoteFacade() throws RemoteException {
        
    }
    
    @Override
    
    
    public boolean findBookByName(String bookname) throws RemoteException {
        bookInventory inv = new bookInventory();
        
        for(int i=0;i<inv.bookList.size();i++){
            System.out.println("the book you searched for is: "+bookname+", while the book now is: "+inv.bookList.get(i).getName());
        if(inv.bookList.get(i).getName().equals(bookname)){
            System.out.println("book found");
            //getBookInfo(inv.bookList.get(i));
            System.out.println(getBookInfo(inv.bookList.get(i).getName()));
           
            return true;
        }
        }
        return false;
    }
    
    
    @Override
    public boolean findBookById(String bookId) throws RemoteException {
         bookInventory inv = new bookInventory();
         for(int i=0;i<inv.bookList.size();i++){
        if(inv.bookList.get(i).getId().equals(bookId)){
            System.out.println("book name: "+inv.bookList.get(i).getName());
            System.out.println(getBookInfo(inv.bookList.get(i).getName()));
            return true;
        }
        }
        return false;
    }


    @Override
    public String getBookInfo(String name) throws RemoteException {
                 bookInventory inv = new bookInventory();
                return(inv.displayBookInfo(name));
       // System.out.println("book name: "+book.getName());
       // System.out.println("book author: "+book.getAuthor());
       // System.out.println("available copies: "+book.getAvailableCopies());
    }

    @Override
    public void viewFine(String studentid) throws RemoteException {
         bookInventory inv = new bookInventory();
         for(int i=0;i<inv.bookBorrowalList.size();i++){
         if(inv.bookBorrowalList.get(i).getStudentId()==studentid) {
             System.out.println("fine: "+inv.bookBorrowalList.get(i).getFine()); 
         }
         }
    }

    @Override
    public boolean borrowBook(String bookId,String studentId) throws RemoteException {
                bookInventory inv = new bookInventory();
                for(int i=0;i<inv.bookList.size();i++){
                if(inv.bookList.get(i).getId().equals(bookId)){
                    Random rand = new Random();
                    bookBorrowal e = new bookBorrowal(rand.nextInt(500),"na","na","na",0.0,inv.bookList.get(i).getId(),studentId,true);
                    inv.addBorrowal(e);
                    
                    return true;
                }
                        }
                return false;
    }

    @Override
    public void extendBorrow(String bookId,String studentId,String extention) throws RemoteException {
                         bookInventory inv = new bookInventory();
                         for(int i=0;i<inv.bookBorrowalList.size();i++){
                             if(inv.bookBorrowalList.get(i).getBookId()==bookId&&inv.bookBorrowalList.get(i).getStudentId()==studentId){
                             inv.bookBorrowalList.get(i).setDeadlineCheckIn(extention);
                             }
                         }
    }

    @Override
    public String getAllBorrowedBooks(String studentId) throws RemoteException {
        //ArrayList<bookBorrowal>temp = new ArrayList();
        bookInventory inv = new bookInventory();
        String result = "";
        /*
        for(int i=0;i<inv.bookBorrowalList.size();i++){
            if(inv.bookBorrowalList.get(i).getStudentId().equals(studentId)){
             result = result+inv.bookBorrowalList.get(i).getBookId()+inv.bookList.get(i).getName()+"\n";
            //temp.add(inv.bookBorrowalList.get(i));
                //System.out.println("book name: "+findBookById(inv.bookBorrowalList.get(i).getBookId()));
            }
        }
*/
        for(int i=0;i<inv.bookBorrowalList.size();i++){
        if(inv.bookBorrowalList.get(i).getStudentId().equals(studentId)){
        result = result +"book id: " +inv.bookBorrowalList.get(i).getBookId()+"\n";
        //+",book name: "+inv.bookList.get(i).getName()
        }
        
        }
        return result;
    }
    
        @Override
    public String getAllBooks()throws RemoteException{
            System.out.println("get all books should start here");
        String result ="";
        bookInventory inv = new bookInventory();
        for(int i=0;i<inv.bookList.size();i++){
        result = result+inv.bookList.get(i).getName()+"\n";
        }
    //return (inv.retrieveAllBooks());
            System.out.println(result);
            return result;
    }

    
}
