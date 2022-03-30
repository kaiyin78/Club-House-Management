/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.*;
import Entity.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Scanner;
import java.lang.String;
import java.lang.NumberFormatException;

/**
 *
 * @author user
 */
public class PromotionMainClass implements Serializable {

    private static Scanner sc = new Scanner(System.in);
    private static final QueueInterface<Promotion> promotion = new LinkedQueue<>();
    private static final QueueInterface<Member> member = new LinkedQueue<>();
    private static LinkedListInterface<staff> staffList = new LinkedList<>();
    private static ListWithIteratorInterface<Court> court = new ArrayListWithIterator<>();
    private static ListWithIteratorInterface<Booking> booking = new ArrayListWithIterator<>();

 public static void MainMenu() throws IOException 
 {
     
        readFile();
        String firstaction = "n";
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        do {
            System.out.println("*************************** Welcome to ClubHouse System!******** *****************");
            System.out.println("---------------------");
            System.out.println("1.Member Login");
            System.out.println("2.Staff Login");
            System.out.println("3.Member Register");
            System.out.println("4.Staff Register");
            System.out.println("5.Exit");
            Scanner FirstChoice = new Scanner(System.in);
            System.out.print("Please select:");
            String FirstSelect = FirstChoice.nextLine();
            switch (FirstSelect) {
                case "1": {
                    System.out.print("Enter the login id: ");
                    String username = sc1.nextLine();

                    System.out.print("Enter passsword: ");
                    String passwd = sc1.nextLine();

                    if (member.getFront().getmemberID().contains(username) && member.getFront().getmemberPassword().contains(passwd)) {
                        System.out.println("Valid account!");
                        System.out.println("You are logged in");
                        MemberLogin();

                    } else {
                        System.out.println("Invalid account.Please Try Again!");
                    }

                }
                break;
                case "2":
                
                    
       String test = "n";
                    System.out.print("Enter the Staff login id: ");
                    String staffname = sc2.nextLine();

                    System.out.print("Enter Staff passsword: ");
                    String staffpasswd = sc2.nextLine();
  for (int i = 0; i < staffList.Getsize(); i++) {
    if (staffList.getEntry(i).getStaffUsername().contains(staffname) && staffList.getEntry(i).getStaffPassword().contains(staffpasswd)){
                        System.out.println("Valid account!");
                        System.out.println("You are logged in as Staff!");
                          Login();
                    
          }else{
                        System.out.println("Invalid account.Please Try Again!");
                    }
                    } 
   
                    break;
                case "3":
                    Register();
                    break;
                case "4":
                    AddNew();
                    break;
                case "5":
                    firstaction = "5";
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Invalid, please enter again.");
                    break;
            }
        } while (!firstaction.equals("5"));
 }
    public static void main(String[] args) throws IOException {
     MainMenu();
    }

    public static void Login() throws IOException {
        String action = "n";
        do {
            System.out.println("---------------------");
            System.out.println("1.Staff Management");
            System.out.println("2.Venue Management");
            System.out.println("3.Promotion Management");
            System.out.println("0.Exit");
            System.out.println("---------------------");
            Scanner MenuChoice = new Scanner(System.in);

            System.out.print("Please select:");
            String MenuSelect = MenuChoice.nextLine();
            switch (MenuSelect) {
                case "1":
                    StaffMenu();
                    break;
                case "2":
                    Venue();
                    break;
                case "3":
                    PromotionManagement();
                    break;                   
                case "0":
                    action = "0";
                    break;
                default:
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Invalid, please enter again.");
                    break;

            }

        } while (!action.equals("0"));

    }

    public static void MemberLogin() throws IOException {
        String action = "n";
        do {
            System.out.println("---------------------");
            System.out.println("1.Appointment");
            System.out.println("2.List Venue");
            System.out.println("3.Promotion Offered");
            System.out.println("4.Member Management");
            System.out.println("0.Exit");
            System.out.println("---------------------");
            Scanner MenuChoice = new Scanner(System.in);

            System.out.print("Please select:");
            String MenuSelect = MenuChoice.nextLine();
            switch (MenuSelect) {
                case "1":
                    Appointment();
                    break;
                case "2":
               DisplayCourt();
                    break;
                case "3":
                    DisplayPromotion();
                    break;
                      case "4":
                    MemberManagement();
                    break;
                case "0":
                    action = "0";
                    break;
                default:
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Invalid, please enter again.");
                    break;

            }

        } while (!action.equals("0"));

    }

    public static void Register() {
        Scanner ReScan = new Scanner(System.in);

        String memberID = "";
        String memberPassword = "";
        String memberName="";
        System.out.print("Please enter Member ID(U001):");
        memberID = ReScan.nextLine();
        System.out.print("Please enter Member Password :");
        memberPassword = ReScan.nextLine();
         System.out.print("Please enter Your Name:");
        memberName = ReScan.nextLine();
        member.enqueue(new Member(memberID, memberPassword, memberName));
    }

    public static void Appointment() {
          String action = "n";
                 	Scanner sc1 = new Scanner(System.in);                     
      do {  
            System.out.println("---------------------");
            System.out.println("1.Make a booking");
            System.out.println("2.Show booking invoice");
            System.out.println("3.Edit booking");
            System.out.println("4.Delete booking");
            System.out.println("5.Exit");
            System.out.println("---------------------");
            Scanner BookingChoice = new Scanner(System.in);
            System.out.print("Please select an option:");
            String BookingSelect = BookingChoice.nextLine();
            
             switch (BookingSelect){ 
                case "1":
                    AddBooking();
                    break;
                    
                case "2":
                    DisplayBooking();
                    break;
                    
                case "3":
                    UpdateBooking();
                    break;
                    
                case "4":
                    DeleteBooking();
                    break;
                    
                case "5":
                    action = "0";
            
                    break;
                    
                default:
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Invalid, please enter again.");
                    break;
             }
      }while(!action.equals("0"));
    }
    

    public static void Venue() {
         String action = "n";
                 	Scanner sc1 = new Scanner(System.in);
            
      do {  
            System.out.println("---------------------");
            System.out.println("1.Add Venue");
            System.out.println("2.Update Venue");
            System.out.println("3.Delete Venue");
            System.out.println("4.Delete  All Venue");
            System.out.println("5.Display Venue");
            System.out.println("6.Exit");
            System.out.println("---------------------");
            Scanner BookingChoice = new Scanner(System.in);
            System.out.print("Please select an option:");
            String BookingSelect = BookingChoice.nextLine();
          
             switch (BookingSelect){ 
                case "1":
                    AddCourt();
                    break;
                    
                case "2":
                    UpdateCourt();
                    break;
                    
                case "3":
                    DeleteCourt();
                    break;
                    
                case "4":
                    DeleteAllCourt();
                    break;
                    
                case "5":
                    DisplayCourt();
                    break;
                    
                case "6":
                    action = "6";
           
                    break;
                    
                default:
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Invalid, please enter again.");
                    break;
             }
      }while(!action.equals("6"));
    
    }
       //Wong Kai Yin Part- Promotion Management

    public static void PromotionManagement() {

        String action = "n";
        do {
            

            System.out.println("************* Select What you want to do! *****************");
            System.out.println("---------------------");
            System.out.println("1.Add Promotion");
            System.out.println("2.Edit Promotion");
            System.out.println("3.Delete Promotion");
                  System.out.println("4.Display Promotion");
            System.out.println("0.Exit");
            System.out.println("---------------------");
            Scanner MenuChoice = new Scanner(System.in);

            System.out.print("Please select:");
            String MenuSelect = MenuChoice.nextLine();
            switch (MenuSelect) {
                case "1":
                    addPromotion();
                    break;
                case "2":
                    editPromotion();
                    break;
                case "3":
                    deletePromotion();
                    break;
                      case "4":
                    DisplayPromotion();
                    break;
                case "0":
                    action = "0";
                    break;
                default:
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Invalid, please enter again.");
                    break;
            }
        } while (!action.equals("0"));
    }
    
     public static void MemberManagement() throws IOException{
      String action = "n";
        do {
            
 System.out.println("************* Member Management *****************");
            System.out.println("************* Select What you want to do! *****************");
            System.out.println("---------------------");
            System.out.println("1.Edit Profile");
            System.out.println("2.Display Profile");
            System.out.println("3.Delete Account");
            System.out.println("0.Exit");
            System.out.println("---------------------");
            Scanner MenuChoice = new Scanner(System.in);

            System.out.print("Please select:");
            String MenuSelect = MenuChoice.nextLine();
            switch (MenuSelect) {
                case "1":
                    EditMemeber();
                    break;
                case "2":
                    DisplayMemeber();
                    break;
                case "3":
                    DeleteMemeber();
                    break;
                case "0":
                    action = "0";
                    break;
                default:
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Invalid, please enter again.");
                    break;
            }
        } while (!action.equals("0"));
     }

    public static void DisplayPromotion() {
        int[] getAllPromotionValue = new int[100];
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("PromotionID      |        Promotion Name         |    Promotion Value    |     Promotion Quantity| ");
        System.out.println("---------------------------------------------------------------------------------------------------");

        if (!promotion.isEmpty()) {
            for (int i = 0; i < promotion.getSize(); i++) {
  int getPromotionValue = promotion.getEntry(i).getPromotionValue();
             getAllPromotionValue[i] = getPromotionValue;
System.out.println(i+1 +")"+promotion.getEntry(i).getPromotionID() + "\t\t\t" + promotion.getEntry(i).getPromotionName() + "\t\t\t\t" + promotion.getEntry(i).getPromotionValue() + "\t\t\t\t" + promotion.getEntry(i).getPromotionQuantity());
            
            }
 System.out.println("Suggestion From System--The Best Value Promotion is ---"+promotion.findLargest(getAllPromotionValue)); 
        }
    }

    public static void addPromotion() {

        Scanner pscan = new Scanner(System.in);

        String PromotionID = "";
        String PromotionName = "";
        int PromotionValue = 0;
        int PromotionQuantity = 0;
        System.out.print("Please enter Promotion ID:");
        PromotionID = pscan.nextLine();
        System.out.print("Please enter Promotion Name:");
        PromotionName = pscan.nextLine();
        System.out.print("Please enter Promotion Value:");
        PromotionValue = pscan.nextInt();
        System.out.print("Please enter the Promotion Quantity:");
        PromotionQuantity = pscan.nextInt();
        promotion.enqueue(new Promotion(PromotionID, PromotionName, PromotionValue, PromotionQuantity));

    }

    public static void deletePromotion() {
   System.out.print("Please enter the promotion Id to delete:");
        Scanner del = new Scanner(System.in);
        String id = del.nextLine();
        
   for (int i = 0; i < promotion.getSize(); i++) {
        if (promotion.getEntry(i).getPromotionID().contains(id)==promotion.testFront()) {
            promotion.dequeue();
            System.out.println("Successfully delete");

        } else if(promotion.getEntry(i).getPromotionID().contains(id)!=promotion.testFront()){
            promotion.dequeueBack(i);
              System.out.println("Successfully delete");

        }
        else{
                      System.out.println("Failed to delete");

        }
   }
    }

    public static void editPromotion() {
        Scanner scan = new Scanner(System.in);
        Scanner escan = new Scanner(System.in);

        String EditPromotionID = "";
        String EditPromotionName = "";
        int EditPromotionValue = 0;
        int EditPromotionQuantity = 0;

        System.out.print("Enter the promotion Id that you wan to Search:");
        String promotionsearch = scan.nextLine();

        for (int i = 0; i < promotion.getSize(); i++) {
            if (promotion.getEntry(i).getPromotionID().contains(promotionsearch)) {

                System.out.print("Enter Promotion ID = ");
                EditPromotionID = escan.nextLine();
                System.out.print("Enter Promotion Name = ");
                EditPromotionName = escan.nextLine();
                System.out.print("Enter Promotion Value = ");
                EditPromotionValue = escan.nextInt();
                System.out.print("Enter Promotion Quantity = ");
                EditPromotionQuantity = escan.nextInt();

                promotion.replace(i, new Promotion(EditPromotionID, EditPromotionName, EditPromotionValue, EditPromotionQuantity));

            }

        }

    }

    
    //Tan Pak kin Part- Staff Management
    public static void StaffMenu() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n"); 
        String action = "0";
        do{
            System.out.println("Staff Module Menu\n");
            System.out.println("1.Add new staff \n2.Edit staff \n3.Delete staff \n4.Display all staff\n");
            System.out.println("5.Exit \nEnter your selection.");
            action = scan.next();
            switch(action){
                case"1" -> AddNew();
                case"2" -> EditStaff();
                case"3" -> DeleteStaff();
                case"4" -> DisplayStaff();
                case"5" -> action = saveFile();
                default -> {
                    System.out.println("\n\n\n");
                    System.out.println("Invalid, please enter again");
                }
            }
            System.out.println("\n\n\n\n");
        }while(!action.equals("5"));
    }

    public static void AddNew() throws IOException {
       Scanner scan = new Scanner(System.in);
        
            
        System.out.println("Enter the user name :");      
        String sUserName = scan.nextLine();
            
        System.out.println("Enter the password :");         
        String sPass = scan.nextLine();
     
        System.out.println("Enter the name :");      
        String sName = scan.nextLine();
            
            
        System.out.println("Enter the salary :");         
        int sSalary = scan.nextInt(); 
            
        staffList.add(new staff(sUserName, sPass, sName, sSalary));
            
        System.out.println("Staff added. ");
        saveFile();

    }

    public static void EditStaff() {
         Scanner scan = new Scanner(System.in); 
        System.out.println("Enter the staff ID you want to edit:");    
        String toUpdate = scan.nextLine();
                      
        for(int i = 0; i < staffList.Getsize(); i++){
                
            if(staffList.getEntry(i).getStaffUsername().contains(toUpdate)){
                                
                                
                System.out.println("Enter new staff ID:");                           
                String sUserName = scan.nextLine();            
                                
                System.out.println("Enter new staff Password:");                        
                String sPass = scan.nextLine();              
                                
                System.out.println("Enter new Name :");               
                String sName = scan.nextLine();
                
                System.out.println("Enter the salary :");      
                int sSalary = scan.nextInt();
                                
                staffList.replace(i,new staff(sUserName, sPass, sName, sSalary));
                            
            }
            else{
                System.out.println("Invalid, please enter again");
            }
        }
    }

    public static void DeleteStaff() {
       Scanner scan = new Scanner(System.in);
            
        System.out.println("Enter the staff ID you want to delete:");
        String toDelete = scan.nextLine();
              
        for(int i = 0; i < staffList.Getsize(); i++){
      
            if(staffList.getEntry(i).getStaffUsername().contains(toDelete)){
        
                staffList.remove(i);
        
                System.out.println("Successfully delete");
        
            }
            else{
                System.out.println("Invalid, please enter again");
            }
        }
    }

    public static void DisplayStaff() {

        Scanner scan = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------");        
        System.out.println("Username  |  Password    |     Name      |     Salary      |   EPF   |");
        System.out.println("---------------------------------------------------------------------------------------------");
        if(!staffList.isEmpty()){ 
            for(int i = 0; i < staffList.Getsize(); i++)             
            {
                System.out.println(staffList.getEntry(i).getStaffUsername() + " " + staffList.getEntry(i).getStaffPassword() 
                        + " " + staffList.getEntry(i).getStaffName() + " " + staffList.getEntry(i).getsSalary() + " "
                + staffList.calculation(staffList.getEntry(i).getsSalary()));              
            }     
        }
        
        System.out.println("Enter the staff ID you want to search (n = exit):");
        String tosearch = scan.nextLine();
        for(int i = 0; i < staffList.Getsize(); i++){
            if(staffList.getEntry(i).getStaffUsername().contains(tosearch)){
        
                System.out.println(staffList.getEntry(i).getStaffUsername() + " " + staffList.getEntry(i).getStaffPassword() 
                        + " " + staffList.getEntry(i).getStaffName() + " " + staffList.getEntry(i).getsSalary()
                        + staffList.calculation(staffList.getEntry(i).getsSalary()));              
        
            }
            else if(tosearch.equals("n")){
                System.out.println("\n\n");
            }
            else{
                System.out.println("Invalid, please enter again");
            }
        }

    }
      
    //Keng Yik Part- Booking 
     public static void AddBooking(){
         
           System.out.println("----------------------------------------------------");
            System.out.println("                ~Available Court~                   ");
            System.out.println("----------------------------------------------------");
            System.out.println("Court ID  |  Court Name  |    Court Price Per Hour  ");
            System.out.println("----------------------------------------------------");
            
if(court.getLength()>=1)
        {
for(int i = 0; i < court.getLength(); i++)
            {
System.out.println(court.getEntry(i).getCourtID()+ "          " + court.getEntry(i).getCourtName()+ "            " + court.getEntry(i).getCourtPricePerHour());
             }
        }else if(court.isEmpty())
        {
            System.out.println("No record!!!");
        }
         
     
        Scanner scan = new Scanner(System.in);

        
        System.out.print("Please enter your username:");
        String newUsername = scan.nextLine();
        System.out.print("Please enter your name:");
        String newCustomerName = scan.nextLine();
        System.out.print("Please enter gender:");
        String newCustomerGender = scan.nextLine();
        System.out.print("Please enter court ID:");
        String newCourtID = scan.nextLine();
        System.out.println("8 (1hour)");
        System.out.println("9 (1hour)");
        System.out.println("10 (1hour)");
        System.out.println("11 (1hour)");
        System.out.println("12 (1hour)");
        System.out.println("13 (1hour)");
        System.out.println("14 (1hour)");
        System.out.println("15 (1hour)");
        System.out.println("16 (1hour)");
        System.out.println("17 (1hour)");
        System.out.println("18 (1hour)");
        System.out.println("19 (1hour)");
        System.out.println("20 (1hour)");
        System.out.println("Please enter time:");
        int newTime=  scan.nextInt();
        System.out.println("Total price: ");
        for(int i = 0; i < court.getLength(); i++)
        {
        if(court.getEntry(i).getCourtID().contains(newCourtID))
        {
            switch (newTime) {
                case 8:
                    {
                        newTime=8;                     
                    }
                case 9:
                    {
                             newTime=9;
                    }
                case 10:
                    {
                          newTime=10;
                    }
                case 11:
                    {
                          newTime=11;
                    }
                case 12:
                    {
                          newTime=12;
                    }
                case 13:
                    {
                          newTime=13;
                    }
                case 14:
                    {
                          newTime=14;
                    }
                case 15:
                    {
                          newTime=15;
                    }
                case 16:
                    {
                          newTime=16;
                    }
                case 17:
                    {
                          newTime=17;
                    }
                case 18:
                    {
                          newTime=18;
                    }
                case 19:
                    {
                          newTime=19;
                    }
                case 20:
                    {
                          newTime=20;                      
                    }
                default:
                    break;
            }
             int TotalPrice = 1 * court.getEntry(i).getCourtPricePerHour();
                        System.out.print(TotalPrice);
            
        booking.add(new Booking(newUsername, newCustomerName, newCustomerGender, newCourtID, newTime, TotalPrice));
        System.out.println("Booking Success!!!");
    
        }
     }    
 }   
public static void DisplayBooking(){ 
    Scanner scan = new Scanner(System.in);   
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Username  |  Customer Name  |    Customer Gender    |    CourtID  |  Time  | Total Price  ");
            System.out.println("------------------------------------------------------------------------------------------");
if(booking.getLength()>=1)
        {
for(int i = 0; i < booking.getLength(); i++)
            {
 System.out.println(booking.getEntry(i).getusername()+ "            " + booking.getEntry(i).getCustomerName()+ "                " + booking.getEntry(i).getCustomerGender()+ "                " + booking.getEntry(i).getCourtID()+ "          " + booking.getEntry(i).getTime());
  
                System.out.println("Do you want to proceed to pay? (y/n)");
                      String answerPay = scan.nextLine();
                      if(answerPay.equals("y")||answerPay.equals("Y"))
                      {
 System.out.println(booking.getEntry(i).getusername()+ booking.getEntry(i).getCustomerName()+ booking.getEntry(i).getCustomerGender()+ booking.getEntry(i).getCourtID()+ booking.getEntry(i).getTime()+ booking.getEntry(i).getTotalPrice());
 System.out.println("Do you want to add Promotion? (y/n)");
                      String answeraddPromotion = scan.nextLine();
                      if(answeraddPromotion.equals("y")||answeraddPromotion.equals("Y"))
                      {
                      DisplayPromotion();
               System.out.println("Please Select One Promotion(Promotion ID):");
               String whatPromotion = scan.nextLine();   
               if(promotion.getEntry(i).getPromotionID().equals(whatPromotion))
               {                            
 System.out.println("Total Price After Promotion is "+ promotion.calculation(booking.getEntry(i).getTotalPrice(), promotion.getEntry(i).getPromotionValue()));                     
                         }else
               {
               System.out.println("Error");
               }
                      }
                      }
            }
        }else if(booking.isEmpty())
        {
            System.out.println("No record!!!");
        }

 
}
    public static void UpdateBooking(){ 
       
             Scanner scan=new Scanner(System.in);
             Scanner escan = new Scanner(System.in);   
             
 ListWithIteratorInterface<Booking> updatebooking = new ArrayListWithIterator<Booking>();

     
                booking.getEntry(0).getusername();
        	System.out.print("Enter the username that you want to Search:");
                String usernamesearch = scan.nextLine();
        for(int i = 0; i < booking.getLength(); i++){
      
        if(booking.getEntry(i).getusername().contains(usernamesearch)){
            
           
                System.out.print("Enter Username = " );
                String updateusername= escan.nextLine();
                System.out.print("Enter Name = " );
                String updateCustomerName= escan.nextLine();
                System.out.print("Enter Gender = " );
                String updateCustomerGender= escan.nextLine();
                System.out.print("Enter Court ID = " );
                String updateCourtID= escan.nextLine();
                System.out.println("8 (1hour)");
                System.out.println("9 (1hour)");
                System.out.println("10 (1hour)");
                System.out.println("11 (1hour)");
                System.out.println("12 (1hour)");
                System.out.println("13 (1hour)");
                System.out.println("14 (1hour)");
                System.out.println("15 (1hour)");
                System.out.println("16 (1hour)");
                System.out.println("17 (1hour)");
                System.out.println("18 (1hour)");
                System.out.println("19 (1hour)");
                System.out.println("20 (1hour)");
                System.out.println("Please enter time:");
                int updateTime=  scan.nextInt();
                       int updateTotalPrice = 1 * court.getEntry(i).getCourtPricePerHour();
                     
 
/*ChangePromotion.add(promotion.getEntry(i).getPromotionID().replace(promotion.getEntry(i).getPromotionID(), EditPromotionID));  */        
booking.replace(i, new Booking(updateusername,updateCustomerName,updateCustomerGender,updateCourtID, updateTime,updateTotalPrice));
        System.out.println("Update Success!!!");
        }else{
     
                System.out.println("Username does not exist!!!");
            }
      
      }
      
   }
   
  
  public static void DeleteBooking(){
  
      Scanner delscan=new Scanner(System.in);
      
      System.out.print("Please enter the username to delete:");
      String usernamedelete = delscan.nextLine(); 
      
            for(int i = 0; i < booking.getLength(); i++){
      if(booking.getEntry(i).getusername().contains(usernamedelete)){
        booking.remove(i);
        System.out.println("Delete Success!!!");
      }
      else
      {
        System.out.println("Username does not exist!!!");
      }
    } 
  
  }
  
    
 //Keng Yik Part- Venue Management

  public static void AddCourt()
  {
    Scanner scan = new Scanner(System.in);

        
        System.out.print("Please enter court ID:");
        String newCourtID = scan.nextLine();
        System.out.print("Please enter court name:");
        String newCourtName = scan.nextLine();
        System.out.print("Please enter court price per hour:");
        int newCourtPricePerHour = scan.nextInt();
        
      
        court.add(new Court(newCourtID, newCourtName, newCourtPricePerHour));
        System.out.println("Court Added!!!");
  }
  
  
  public static void DisplayCourt(){

            System.out.println("----------------------------------------------------");
            System.out.println("Court ID  |  Court Name  |    Court Price Per Hour ");
            System.out.println("----------------------------------------------------");
            
if(court.getLength()>=1)
        {
for(int i = 0; i < court.getLength(); i++)
            {
System.out.println(court.getEntry(i).getCourtID()+ "          " + court.getEntry(i).getCourtName()+ "            " + court.getEntry(i).getCourtPricePerHour());
            }
        }
else if(court.isEmpty())
        {
            System.out.println("No record!!!");
        }
}
  
  
  public static void UpdateCourt()
  {
  
             Scanner scan=new Scanner(System.in);
             Scanner escan = new Scanner(System.in);   
             
 ListWithIteratorInterface<Court> updatecourt = new ArrayListWithIterator<Court>();

     
                court.getEntry(0).getCourtID();
        	System.out.print("Enter the court ID that you want to Search:");
                String CourtIDsearch = scan.nextLine();
        for(int i = 0; i < court.getLength(); i++){
      
        if(court.getEntry(i).getCourtID().contains(CourtIDsearch)){
            
           
                System.out.print("Enter Court ID: " );
                String updateCourtID= escan.nextLine();
                System.out.print("Enter Court Name: " );
                String updateCourtName= escan.nextLine();
                System.out.print("Enter Court Price Per Hour " );
                int updateCourtPricePerHour= escan.nextInt();
                
                     
 
      
court.replace(i, new Court(updateCourtID,updateCourtName,updateCourtPricePerHour));
System.out.println("Update Success!!!");
        
        }else{
     
                System.out.println("Court ID does not exist!!!");
            }
      
      }
  }
  
  
  public static void DeleteCourt()
  {
  
      Scanner delscan=new Scanner(System.in);
      
      System.out.print("Please enter the Court ID to delete:");
      String CourtIDdelete = delscan.nextLine(); 
      
            for(int i = 0; i < court.getLength(); i++){
      if(court.getEntry(i).getCourtID().contains(CourtIDdelete)){
        court.remove(i);
        System.out.println("Successfully delete!!!");
        
      }
      else
      {
        System.out.println("Court ID does not exist!!!");
      }
    } 
  }
  
  public static void DeleteAllCourt()
   {
        String action = "n";
   do{
       Scanner delallscan=new Scanner(System.in);
       
        System.out.println("1.Yes");
        System.out.println("2.No");
        
            Scanner choice = new Scanner(System.in);
            System.out.print("Please select:");
            String FirstSelect = choice.nextLine();
            switch (FirstSelect) {
                case "1":
                    court.clear();
                    System.out.println("All record successfully deleted!!!");
                            
                case "2":
                    action = "0";
                    
                default:
                    System.out.println("\n\n\n\n\n");
                    System.out.println("Invalid, please enter again.");
                    break;
            }
            } while (!action.equals("0"));
   }

  
     public static String saveFile() throws IOException{
         
         File myObj = new File("acc.txt"); 
         if (myObj.delete()) { 
             System.out.println("Deleted the file: " + myObj.getName());
         } else { 
             System.out.println("Failed to delete the file.");
         } 
         try (FileWriter writer = new FileWriter("acc.txt")) {
            for(int i = 0; i < staffList.Getsize(); i++) {
                writer.write(staffList.getEntry(i).getStaffUsername() + "!" + staffList.getEntry(i).getStaffPassword() 
                        + "!" + staffList.getEntry(i).getStaffName() + "!" + staffList.getEntry(i).getsSalary() + System.lineSeparator());
            }
        }
        return "5";
     }
     
     public static void readFile() throws IOException{ 
         try {
             File myObj = new File("acc.txt");
             if (myObj.createNewFile()) {   
                 System.out.println("File created: " + myObj.getName());      
             } else {     
                 System.out.println("File already exists."); 
             }  
         } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();  
         }
        File filename = new File("acc.txt");
        try (Scanner myReader = new Scanner(filename)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split("!");
                String sUserName = parts[0]; // 004-
                String sPass = parts[1]; // 034556String sUserName = parts[0]; // 004-
                String sName = parts[2]; // 034556
                int sSalary = Integer.parseInt(parts[3]); 
                staffList.add(new staff(sUserName, sPass, sName, sSalary));
            }
        }
     }
  
  
       public static void EditMemeber(){
         Scanner scan = new Scanner(System.in);
        Scanner escan = new Scanner(System.in);

        String memberID = "";
        String memberPassword = "";
     String memberName = "";

        System.out.println("Enter Your Member ID:");
        String memberSearch = scan.nextLine();

        for (int i = 0; i < member.getSize(); i++) {
   if (member.getEntry(i).getmemberID().contains(memberSearch)) {

                System.out.print("Enter New Member ID = ");
                memberID = escan.nextLine();
                System.out.print("Enter  New Member Password = ");
                memberPassword = escan.nextLine();
                System.out.print("Enter New Member Name = ");
                memberName = escan.nextLine();
 member.replace(i, new Member(memberID, memberPassword, memberName));
System.out.println("Account Editd");
            }
        }
       }
  
              public static void DeleteMemeber() throws IOException{
       System.out.println("Are you confirm to delete account? (y/n):");
        Scanner del = new Scanner(System.in);
        String id = del.nextLine();
        

        if (id.equals("y")||id.equals("Y")) {
             System.out.println("Account Deleted, Back to Main Menu!");
        member.clear();
        MainMenu();
        } else if(id.equals("n")||id.equals("N")){
       
  System.out.print("OKay");
        }
        
 
       }
                  public static void DisplayMemeber(){

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("MemberID      |        Member Password        |    Member Name    |  ");
        System.out.println("---------------------------------------------------------------------------------------------------");

        if (!member.isEmpty()) {
            for (int i = 0; i < member.getSize(); i++) {
System.out.println(i+1 +")"+member.getEntry(i).getmemberID()+ "\t\t\t" + member.getEntry(i).getmemberPassword() + "\t\t\t\t" + member.getEntry(i).getmemberName());
            
            }
 
        }
       }
}
