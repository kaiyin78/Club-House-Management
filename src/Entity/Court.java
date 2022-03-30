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
public class Court implements Serializable{
    
    private String CourtID="";
    private String CourtName="";
    private int CourtPricePerHour=0;
    
   public Court(String CourtID, String CourtName, int CourtPricePerHour) {
     
        this.CourtID = CourtID;
        this.CourtName = CourtName;
        this.CourtPricePerHour = CourtPricePerHour;
    }
    
    public Court()
    {
   CourtID = "";
   CourtName = "";
   CourtPricePerHour = 0;
    
    }
    
   public String getCourtID() {
        return CourtID;
    }

    public void setCourtID(String CourtID) {
        this.CourtID = CourtID;
    }
   public String getCourtName() {
        return CourtName;
    }

    public void setCourtName(String CourtName) {
        this.CourtName = CourtName;
    }
   public int getCourtPricePerHour() {
        return CourtPricePerHour;
    }

    public void setCourtPricePerHour(int CourtPricePerHour) {
        this.CourtPricePerHour = CourtPricePerHour;
    }
}
