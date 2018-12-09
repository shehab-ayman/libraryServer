/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminSubSystem;
import bookSubSystem.bookDataMapper;
import static bookSubSystem.bookInventory.bookList;
import java.util.ArrayList;
/**
 *
 * @author User.
 */
public class adminList {
    
    public static ArrayList<admin> adminList = new ArrayList();
    static adminDataMapper adm = new adminDataMapper();

    public adminList() {
adminList = adm.retrieveAllAdmins();
        
    }
    
    
    
    public String displayAllAdmins()
    {
        String result="";
        for(int i=0;i<adminList.size();i++)
        {
            System.out.println(i+":"+adminList.get(i).getAdminName());
            result=result+adminList.get(i).getAdminName()+" \n";
        }
        return (result);
    }
    
    public void addAdmin(String adminName,String username,String password,String adminId)
    {
        admin ad = new admin(adminName, username, password, adminId);
        adm.addAdmin(ad);
    }
    public void deleteAdmin(String adminName,String username,String password,String adminId)
    {
        admin ad = new admin(adminName, username, password, adminId);
        for(int i=0;i<adminList.size()-1;i++){
            if(adminList.get(i).getAdminId().equals(adminId)){
        adminList.remove(i);
    }
        }
        adm.deleteAdmin(ad);
    }
    public void updateAdmin(String adminName,String username,String password,String adminId)
    {
            admin ad = new admin(adminName, username, password, adminId);
        for(int i=0;i<adminList.size()-1;i++){
             if(adminList.get(i).getUsername().equals(username)){
        adminList.get(i).setPassword(password);
        adminList.get(i).setAdminId(adminId);
        adminList.get(i).setAdminName(adminName);
    }
        }
        adm.updateAdmin(ad);
    }
    public admin retrieveAdmin(String adminId)
    {
            for(int i=0;i<adminList.size()-1;i++){
    if(adminList.get(i).getAdminId().equals(adminId)){
    return adminList.get(i);
    }
    }
    return null;
    }
}
