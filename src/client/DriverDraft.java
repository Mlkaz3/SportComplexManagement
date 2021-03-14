/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class DriverDraft {

    public static void main(String[] args) {
        int ch = 0;
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("***************************************************");
        System.out.println("*               TARUC SPORTS COMPLEX              *");
        System.out.println("*                MANAGEMENT SYSTEM                *");
        System.out.println("*                                                 *");
        System.out.println("*    Select an Option                             *");
        System.out.println("*    [1] Facilities                               *");
        System.out.println("*    [2] Equipment                                *");
        System.out.println("*    [3] Maintenance                              *");
        System.out.println("*    [4] Usage Log                                *");
        System.out.println("*    [5] Exit                                     *");
        System.out.println("*                                                 *");
        System.out.println("***************************************************");
        System.out.println();

        System.out.print("Please select your choice: ");
        ch = input.nextInt();

        switch (ch) {
            case 1:
                //facilities action
                break;
            case 2:
                System.out.println();
                //equipment action
                break;
            case 3:
                System.out.println();
                //maintanence action
                break;
            case 4:
                System.out.println();
                //usage log action
                //first will print today's reservation(bottom of registration) and registration queue (max of 15 row)
                System.out.println("                                                                                                          Date: ");
                System.out.println("                                                                                                          Time: ");
                System.out.println("                                                                                                          Day : ");
                System.out.println("                                                                                                          Day : ");
                System.out.println("\n                                                       REGISTRATION REPORT LOG");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("RDate       RID        Name      Category           ReservedStartTime     ReservedEndTime     CheckedInTime       CheckOutTime    Status");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("                                                            no record yet. ");
                System.out.println("");
                System.out.println("");
                System.out.println("\n                                                       RESERVATION REPORT LOG");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("RDate       RID        Name      Category           ReservedStartTime     ReservedEndTime     CheckedInTime       CheckOutTime    Status");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("                                                            no record yet. ");
                System.out.println("");
                System.out.println("");
                
                
                //then enable user to choose next page or perform action 
                System.out.println("");
                System.out.println("----------------");
                System.out.println("ACTION COMMAND: ");
                System.out.println("----------------");
                System.out.println("PLS NEXT - show next page of registration report");
                System.out.println("PLS UPDATE [NO.]- update registration report at position [NO.]");
                System.out.println("PLS VIEW [NO.] - view details of registration report at position [NO.]");
                System.out.println("PLS FILTER - filter registration report at position [NO.]");
                System.out.println("PLS SHOW - filter registration report at position [NO.]");
                System.out.println("select reservation record at when... ");
                System.out.println("check if which record exist ... ");
                System.out.println("check how many rows of record exist... ");
                System.out.println("replacing record??? ");
                System.out.println("remove record??? ");
                //actions include: View Details at position X / first row / last row 
                //actions include: Update Details at position X / position 1/ last position
                //actions include: Filter report based on date, ID, facilities, equipments, Status 
                //finally will have usage report (not sure doable or not) 
                break;
            case 5:
                break;
            default:
                System.out.println();
                System.out.println("Error. Please select a correct choice.");
                break;
        }
    }
}
