/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminSubSystem;
import java.util.Random;

/**
 *
 * @author User
 */
public class admin {
    public String adminName;
    public String username;
    public String password;
    public String adminId;
    
    public admin()
{

}

public admin(String adminName, String username,String password,String adminId)
{
this.adminName=adminName;
this.username=username;
this.password=password;
this.adminId=adminId;

}

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }


  public void setPassword(String password)
  {
      this.password=password;
  }
  public String getPassword()
  {
      return password;
  }

 
  public void setAdminId(String adminId )
  {
      this.adminId=adminId;
  }
     public String getAdminId() {
        return adminId;
    }
     public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }
}

