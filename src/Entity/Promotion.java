/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author Wong Kai Yin
*/
public class Promotion implements Serializable{

    private String PromotionID ="";
    private String PromotionName="";
    private int PromotionValue=0;
    private int PromotionQuantity=0;

   public Promotion(String PromotionID, String PromotionName, int PromotionValue, int PromotionQuantity) {
     
        this.PromotionID = PromotionID;
        this.PromotionName = PromotionName;
        this.PromotionValue = PromotionValue;
        this.PromotionQuantity = PromotionQuantity;
    }

  public Promotion(){
  PromotionID="";
  PromotionName="";
  PromotionValue=0;
  PromotionQuantity=0;
  }
    
    public String getPromotionID() {
        return PromotionID;
    }

    public void setPromotionID(String PromotionID) {
        this.PromotionID = PromotionID;
    }

    public String getPromotionName() {
        return PromotionName;
    }

    public void setPromotionName(String PromotionName) {
        this.PromotionName = PromotionName;
    }

    public int getPromotionValue() {
        return PromotionValue;
    }

    public void setPromotionValue(int PromotionValue) {
        this.PromotionValue = PromotionValue;
    }

    public int getPromotionQuantity() {
        return PromotionQuantity;
    }

    public void setPromotionQuantity(int PromotionQuantity) {
        this.PromotionQuantity = PromotionQuantity;
    }
   
    
    
   
}
