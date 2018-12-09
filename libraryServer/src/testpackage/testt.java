/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;
import adminSubSystem.*;
import bookSubSystem.bookBorrowal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.*;
import rminewserver.*;
import static testpackage.test.testborrowaldb;
/**
 *
 * @author User
 */
public class testt {
    public static void main(String[] args){
    //testtborrowaldb();
    //testadmin();
    admin();
    }
    
     public static void testtborrowaldb(){
    adminDataMapper adb = new adminDataMapper();
    adminList al=new adminList();
    admin a1 = new admin("moh","1","12","mohamed");
    admin a2 = new admin("ahm","2","13","ahmed");
    admin a3 = new admin("al","3","14","ali");

   adb.addAdmin(a1);
   adb.addAdmin(a2);
   al.addAdmin("al","3","14","ali");
   
   ArrayList<admin> resultt = new ArrayList();
   resultt = adb.retrieveAllAdmins();
      for(int i=0;i<resultt.size();i++){
       System.out.println(resultt.get(i).getAdminId()+" : "+resultt.get(i).getAdminName());
   }
    adb.closeConnection();
}
     public static void testadmindb(){
    adminDataMapper adb = new adminDataMapper();
    adminList al=new adminList();
        admin admin1 = new admin("sama","sam","asm","12");
        admin admin2 = new admin("mahmoud","mah","opa","16");
        admin admin3 = new admin("ussef","uss","usd","45");
        adb.addAdmin(admin1);
        adb.addAdmin(admin2);
        al.addAdmin("ussef","uss","usd","45");
        
        ArrayList<admin> resultt = new ArrayList();
        resultt = adb.retrieveAllAdmins();
        for(int i=0;i<resultt.size();i++){
            System.out.println(resultt.get(i).getAdminName());
        }
        adb.closeConnection();
     }
     public static void testadmin(){
         
        try {
            adminInterfaceImplementation i = new adminInterfaceImplementation();
              admin a = new admin(); 
              i.addAdmin("ussef","uss","usd","45");
        } catch (RemoteException ex) {
            Logger.getLogger(testt.class.getName()).log(Level.SEVERE, null, ex);
        }
   
     
     }
    
      public static void admin(){
          
          adminDataMapper adm=new adminDataMapper();
          ArrayList<admin> adminlist = new ArrayList();
          adminlist=adm.retrieveAllAdmins();
          for(int i=0;i<adminlist.size();i++){
            System.out.println(adminlist.get(i).getAdminName());
        }
          System.out.println("------------------------------------");
        try {
            adminInterfaceImplementation ai = new adminInterfaceImplementation();
            String result = ai.displayAllAdmins();
            System.out.println(result);
        } catch (RemoteException ex) {
            Logger.getLogger(testt.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        adm.closeConnection();
      }
          
}