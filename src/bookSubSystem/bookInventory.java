/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookSubSystem;

import java.util.ArrayList;

/**
 *
 * @author Shehab
 */
public class bookInventory {
    public static  ArrayList <book> bookList = new  ArrayList();
    public static  ArrayList <bookBorrowal> bookBorrowalList = new ArrayList();
    static bookDataMapper dm = new bookDataMapper();

    public bookInventory() {
        bookDataMapper dm = new bookDataMapper();
        bookList=dm.retrieveAllBooks();
        bookBorrowalList=dm.retrieveAllBorrowals();
    }
    public String displayBookInfo(String bookName){
        String result = "";
    for(int i=0;i<bookList.size();i++){
    if(bookList.get(i).getName()==bookName){
    result = "book name: "+ bookList.get(i).getName()+ ", book id: "+bookList.get(i).getId()+", book author: "+bookList.get(i).getAuthor();
    }
    }
    return(result);
    }
    public ArrayList<book> retrieveAllBooks(){
    return (bookList);
    }
    public ArrayList<bookBorrowal>retrieveAllBookBorrowals(){
    return(bookBorrowalList);
    }
    
    public void displayAllBooks(){
    
        for(int i=0;i<bookList.size()-1;i++){
            System.out.println(i+": "+bookList.get(i).getName());
        }
    }
    public void displayAllBorrowals(){
        
        for(int i=0;i<bookBorrowalList.size()-1;i++){
            System.out.println(i+": "+bookBorrowalList.get(i).getBorrowalNumber()+", "+bookBorrowalList.get(i).getBookId());
        }
    }
    public void addBook(book book){
    bookList.add(book);
    dm.addBook(book);
    }
    public void deleteBook(book book){
    for(int i=0;i<bookList.size()-1;i++){
    if(bookList.get(i).getId()==book.getId()){
        bookList.remove(i);
    }
    }
    dm.deleteBook(book);
    }
    public void updateBook(book book){
    for(int i=0;i<bookList.size()-1;i++){
    if(bookList.get(i).getId()==book.getId()){
        bookList.get(i).setType(book.getType());
        bookList.get(i).setName(book.getName());
        bookList.get(i).setAuthor(book.getAuthor());
        bookList.get(i).setAvailableCopies(i);
        bookList.get(i).setTotalCopies(book.getTotalCopies());
    }
    }
    
    dm.updateBook(book);
    }
    public book retrieveBook(String name){
    for(int i=0;i<bookList.size()-1;i++){
    if(bookList.get(i).getName()==name){
    return bookList.get(i);
    }
    }
    return null;
    }
    public void addBorrowal(bookBorrowal bookBorrowal1){
    bookBorrowalList.add(bookBorrowal1);
    dm.addBorrowal(bookBorrowal1);
    }
    public void updateBorrowal(bookBorrowal bookBorrowal1){
    for(int i=0;i<bookBorrowalList.size()-1;i++){
    if(bookBorrowal1.getBorrowalNumber()==bookBorrowalList.get(i).getBorrowalNumber()){
        bookBorrowalList.get(i).approveBorrow(bookBorrowal1.isApproved);
        bookBorrowalList.get(i).setDeadlineCheckIn(bookBorrowal1.getDeadlineCheckIn());
        bookBorrowalList.get(i).setCheckInDate(bookBorrowal1.getCheckInDate());
        bookBorrowalList.get(i).setCheckOutDate(bookBorrowal1.getCheckOutDate());
    }
    } 
    dm.updateBorrowal(bookBorrowal1);
    }
    public void deleteBorrowal(bookBorrowal bookBorrowal){
    for(int i=0;i<bookBorrowalList.size()-1;i++){
    if(bookBorrowalList.get(i).getBorrowalNumber()==bookBorrowal.getBorrowalNumber()){
    bookBorrowalList.remove(i);
    }
    }
    dm.deleteBorrowal(bookBorrowal);
    }
    public bookBorrowal retrieveBorrowal(int borrowalNumber){
    for(int i=0;i<bookBorrowalList.size()-1;i++){
    if(borrowalNumber==bookBorrowalList.get(i).getBorrowalNumber())
        return bookBorrowalList.get(i);
    }
        
    return null;
    }
    
    }
    

