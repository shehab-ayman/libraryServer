/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import adminSubSystem.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import bookSubSystem.*;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class adminInterfaceImplementation extends UnicastRemoteObject implements adminInterface{

    public adminInterfaceImplementation() throws RemoteException {
    }

    
    @Override
    public String displayAllAdmins() throws RemoteException {
        
       adminList adm = new adminList();
      String result = adm.displayAllAdmins();
       
        return(result);
    }

    @Override
    public boolean addAdmin(String username, String password, String adminId, String adminName) throws RemoteException {
     // admin ad = new admin(adminName, username, password, adminId);
     adminList adm = new adminList();
     adm.addAdmin(adminName, username, password, adminId);
      return true;
    }

    @Override
    public boolean deleteAdmin(String username, String password, String adminId, String adminName) throws RemoteException {
    adminList adm = new adminList();
    adm.deleteAdmin(adminName, username, password, adminId);
      return true;
    }

    @Override
    public boolean updateAdmin(String username, String password, String adminId, String adminName) throws RemoteException {
       adminList adm = new adminList();
       adm.updateAdmin(adminName, username, password, adminId);
         return true;
    }

    @Override
    public boolean retrieveAdmin(String username, String password, String adminId, String adminName) throws RemoteException {
      adminList adm = new adminList();
      adm.retrieveAdmin(adminId);
        return true;
    }
    
   
    
    
        
}
