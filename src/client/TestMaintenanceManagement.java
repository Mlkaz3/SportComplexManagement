/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author YJ
 */
public class TestMaintenanceManagement {

    public static MaintenanceManagement maintenanceMgmt = new MaintenanceManagement();

    public static void MaintenanceManagementMenu() throws ParseException {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*              Maintenance Management             *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] Manage Appointments                      *");
                System.out.println("*    [2] Add Appointment                          *");
                System.out.println("*    [3] Cancel Appointment                       *");
                System.out.println("*    [4] Edit Appointment                         *");
                System.out.println("*    [5] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println();
                        manageAppt();
                        break;
                    case 2:
                        System.out.println();
                        maintenanceMgmt.addAppt();
                        break;
                    case 3:
                        System.out.println();
                        maintenanceMgmt.cancelAppt(); //use row num to access maintenance object
                        break;
                    case 4:
                        System.out.println();
                        //Delivery();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 5.");
            }

        } while (ch != 5);

    }

    public static void manageAppt() {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*               Manage Appointments               *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] Send for maintenance                     *");
                System.out.println("*    [2] Manage completion                        *");
                System.out.println("*    [3] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1:
                        maintenanceMgmt.serveFront();
                        break;
                    case 2:
                        System.out.println();
                        maintenanceMgmt.manageCompletion();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 5.");
            }

        } while (ch != 3);

    }

    public static void main(String[] args) throws ParseException {
        MaintenanceManagementMenu();
    }
}
