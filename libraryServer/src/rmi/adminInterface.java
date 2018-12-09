/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public interface adminInterface extends Remote{
    
    public String displayAllAdmins ()throws RemoteException;
    public boolean addAdmin (String username,String password,String adminId,String adminName)throws RemoteException;
    public boolean deleteAdmin (String username,String password,String adminId,String adminName)throws RemoteException;
    public boolean updateAdmin (String username,String password,String adminId,String adminName)throws RemoteException;
    public boolean retrieveAdmin (String username,String password,String adminId,String adminName)throws RemoteException;
    
}
