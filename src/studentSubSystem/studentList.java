/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentSubSystem;

import java.util.ArrayList;

/**
 *
 * @author Shehab
 */
public class studentList {
    public static  ArrayList <student> studentList = new  ArrayList();
    static studentDataMapper dm = new studentDataMapper();
    String result = "";
   
    public studentList() 
    {studentList=dm.retrieveAllStudents();
    } 
    public String displayAllStudents()
    {
        for(int i=0;i<studentList.size()-1;i++){
           result=result+(studentList.get(i).getName()+" : " );
           result=result+(studentList.get(i).getId())+" : ";
           result=result+(studentList.get(i).getEmail()+" : ");
           result=result+(studentList.get(i).getUsername()+" : ");
           result=result+(studentList.get(i).getPassword()+  " \n" );
        }
        return result;        
    }
   
    public void addStudent(student s)
    {
    studentList.add(s);
    dm.addStudent(s);
    }
    
    public void deleteStudent(student s)
    {
    for(int i=0;i<studentList.size()-1;i++){
    if(studentList.get(i).getId().equals(s.getId())){
        studentList.remove(i);
    }
    }
    dm.deleteStudent(s);
    }

    
    public void updateStudent(student s){
    for(int i=0;i<studentList.size()-1;i++){
    if(studentList.get(i).getId().equals(s.getId())){
        studentList.get(i).setId(s.getId());
        studentList.get(i).setName(s.getName());
        studentList.get(i).setEmail(s.getEmail());
        studentList.get(i).setBalance(s.getBalance());
        studentList.get(i).setUsername(s.getUsername());
        studentList.get(i).setPassword(s.getPassword());
    }
    }
    
    dm.updateStudent(s);
    }
    
    public student retrieveStudent(String id){
    for(int i=0;i<studentList.size()-1;i++){
    if(studentList.get(i).getId().equals(id)){
    return studentList.get(i);
    }
    }
    return null;
    }
   public boolean logIn(String username,String password){

       
       
      for(int i=0;i<studentList.size()-1;i++){
         if(studentList.get(i).getUsername().equals(username)&&studentList.get(i).getPassword().equals(password) ){
            return true;       }
   }
 //    return dm.logIn(username, password);
   return false;
   }
}