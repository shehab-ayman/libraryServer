/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentSubSystem;

/**
 *
 * @author Shehab
 */
public class userAuthentication {
    
    public userAuthentication() {
    }

   
    public boolean logIn(String username, String password)
    {
       studentList sl=new studentList();
      return sl.logIn(username, password);
    }

    
}
