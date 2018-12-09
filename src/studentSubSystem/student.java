/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentSubSystem;
import java.util.Random;

/**
 *
 * @author Shehab
 */
public class student {
    public String name;
    public String id;
    public String email;
    public String username;
    public String password;
    public double balance;

    public student() {
    }

    public student(String name, String id, String email, String username, String password, double balance) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    
    
    public void displayInfo()
    {    
    String info = name+ "," + id + "," + email + "," + balance + "," + username + "," + password; 
        System.out.println(info);
    }
    
    public void addFunds(double cash)
    {
        if (cash>=0)
        { 
            this.balance=this.balance+cash;
            System.out.println("amount"+cash+"was added to your account"+this.username);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

   
 
    
}
