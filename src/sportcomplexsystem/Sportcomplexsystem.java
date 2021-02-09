/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportcomplexsystem;

import java.util.Scanner;

/**
 *
 * @author winnieyap
 */
public class Sportcomplexsystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // TODO code application logic here
        System.out.println("Today's Reservation");
        System.out.println("RID        Name      Category           StartTime(In)       EndTime(Out)");
        System.out.println("R0000001   Winnie    Facilities-Gym1    01:25PM             02:25PM     ");
        System.out.println("R0000002   Yap       Facilities-Gym2    01:25PM             02:25PM     ");
        
        
        System.out.println("TARUC SPORT COMPLEX");
        System.out.println("Please select a choice");
        System.out.println("[1]Facilities");
        System.out.println("[2]Equipment");
        System.out.println("[3]Others");
        
        System.out.print("-> ");
        String selection = scanner.nextLine();
        
        if(null==selection){
            //do stg if selection is null
        }
        else switch (selection) {
            case "1":
                System.out.println("FACILITIES");
                System.out.println("----------");
                System.out.println("Reserve On The Spot");
                System.out.println("Reservation Check In"); 
                System.out.println("Reservation Check Out");
                System.out.println("Reservation Alteration");
                System.out.println("Reservation Cancelation");
                break;
            case "2":
                System.out.println("EQUIPMENT");
                System.out.println("---------");
                System.out.println("Borrowing");
                System.out.println("Returning"); 
                break;
            case "3":
                System.out.println("OTHERS");
            default:
                break;
        }
        
        
    }
    
}
