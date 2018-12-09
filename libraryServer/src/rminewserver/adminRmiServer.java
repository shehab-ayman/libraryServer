/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminewserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.*;
/**
 *
 * @author User
 */
public class adminRmiServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        try {
            adminInterfaceImplementation a = new adminInterfaceImplementation();
            Registry r = LocateRegistry.createRegistry(1099);
             r.bind("adminsubsystem", a);
             System.out.println("The server is ready");
        }
         catch (Exception ex) {
             System.out.println("Exception occured");
         }
    }
}
