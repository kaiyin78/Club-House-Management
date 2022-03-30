/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author Keng Yik
*/
public class Booking implements Serializable{

    private String username="";
    private String CustomerName="";
    private String CustomerGender="";
    private String CourtID="";
    private int Time=0;
    private int TotalPrice=0;

   public Booking(String username, String CustomerName, String CustomerGender, String CourtID, int Time, int TotalPrice) {
     
        this.username = username;
        this.CustomerName = CustomerName;
        this.CustomerGender = CustomerGender;
        this.CourtID = CourtID;
        this.Time = Time;
        this.TotalPrice = TotalPrice;
    }

  public Booking(){
  username="";
  CustomerName="";
  CustomerGender="";
  CourtID="";
  Time=0;
  TotalPrice=0;
  }
    
    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }
    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCustomerGender() {
        return CustomerGender;
    }

    public void setCustomerGender(String CustomerGender) {
        this.CustomerGender = CustomerGender;
    }

    public String getCourtID() {
        return CourtID;
    }

    public void setCourtID(String CourtID) {
        this.CourtID = CourtID;
    }
    public int getTime() {
        return Time;
    }

    public void setTime(int Time) {
        this.Time = Time;
    }
    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }
    
    
}
