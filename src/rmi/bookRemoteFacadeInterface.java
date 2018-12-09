/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
//import bookSubSystem.*;
/**
 *
 * @author Shehab
 */
public interface bookRemoteFacadeInterface extends Remote{
    public boolean findBookByName(String bookname) throws RemoteException;
    public boolean findBookById(String bookId) throws RemoteException;
    public String getBookInfo(String name) throws RemoteException;
    public void viewFine(String studentid) throws RemoteException;
    public boolean borrowBook(String bookId,String studentId) throws RemoteException;
    public boolean extendBorrow(String bookId,String studentId,String extention) throws RemoteException;
    public String getAllBorrowedBooks(String studentId) throws RemoteException;
    public String getAllBooks()throws RemoteException;
}
