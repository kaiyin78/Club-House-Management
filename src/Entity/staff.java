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
import java.io.Serializable;

/**
 *
 * @author tanki
 */
public class staff implements Serializable{

    private String sUsername;
    private String sPass;
    private String sName;
    private int sSalary;

    public staff(String sUsername, String sPass, String sName, int sSalary) {
        this.sUsername = sUsername;
        this.sPass = sPass;
        this.sName = sName;
        this.sSalary = sSalary;
    }
    
    public staff(){
        sUsername = "";
        sPass = "";
        sName = "";
        sSalary = 0;
    }

    public String getStaffUsername() {
        return sUsername;
    }

    public String getStaffPassword() {
        return sPass;
    }

    public String getStaffName() {
        return sName;
    }

    public int getsSalary() {
        return sSalary;
    }
    

    public void setStaffUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public void setStaffPassword(String sPass) {
        this.sPass = sPass;
    }

    public void setStaffName(String sName) {
        this.sName = sName;
    }

    public void setsSalary(int sSalary) {
        this.sSalary = sSalary;
    }
    
    
    
}