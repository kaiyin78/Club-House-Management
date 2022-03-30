/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author user
 */
public class Member {
    private String memberID;
    private String memberPassword;
    private String memberName;
    
	
    public Member(String memberID,String memberPassword, String memberName) {
    	this.memberID=memberID;
    	this.memberPassword=memberPassword;
        this.memberName=memberName;
    }

   public Member(){
   memberID="";
   memberPassword="";
   memberName="";
   }
   
    
    public void setmemberID(String memberID)
    {
    this.memberID=memberID;
    }
    public void setmemberPassword(String memberPassword)
    {
    this.memberPassword=memberPassword;
    }
    public void setmemberName(String memberName)
    {
    this.memberName=memberName;
    }

    public String getmemberID()
    {
    return memberID;
    }
    public String getmemberPassword()
    {
    return memberPassword;
    }
    public String getmemberName()
    {
    return memberName;
    }

}
