/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author wong kai yin
 */
public class Venue implements Serializable{
 private String VenueID ="";
    private String VenueName="";
    private int VenuePrice=0;
    private int VenueQuantity=0;
    
     public Venue(String VenueID, String VenueName, int VenuePrice, int VenueQuantity) {
     
        this.VenueID = VenueID;
        this.VenueName = VenueName;
        this.VenuePrice = VenuePrice;
        this.VenueQuantity = VenueQuantity;
    }
    
     public Venue(){
  VenueID="";
  VenueName="";
  VenuePrice=0;
  VenueQuantity=0;
  }

    public String getVenueID() {
        return VenueID;
    }

    public void setVenueID(String VenueID) {
        this.VenueID = VenueID;
    }

    public String getVenueName() {
        return VenueName;
    }

    public void setVenueName(String VenueName) {
        this.VenueName = VenueName;
    }

    public int getVenuePrice() {
        return VenuePrice;
    }

    public void setVenuePrice(int VenuePrice) {
        this.VenuePrice = VenuePrice;
    }

    public int getVenueQuantity() {
        return VenueQuantity;
    }

    public void setVenueQuantity(int VenueQuantity) {
        this.VenueQuantity = VenueQuantity;
    }
        
     
}
