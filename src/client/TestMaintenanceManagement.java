/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.Facility;
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
                System.out.println("*    [1] View Appointments                        *");
                System.out.println("*    [2] Add Appointment                          *");
                System.out.println("*    [3] Cancel Appointment                       *");
                System.out.println("*    [4] Edit Appointment                         *");
                System.out.println("*    [5] Manage Appointments                      *");
                System.out.println("*    [6] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1 -> {
                       maintenanceMgmt.displayQueue();
                       MaintenanceManagement.pressAnyKeyToContinue();
                    }
                    case 2 -> {
                        maintenanceMgmt.addAppt();
                    }
                    case 3 -> {
                        maintenanceMgmt.cancelAppt();
                    }
                    case 4 -> {
                        maintenanceMgmt.editAppt();
                    }
                    case 5 -> {
                        manageAppt();
                    }
                    case 6 -> {
                        
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 5.");
            }

        } while (ch != 6);
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
                    case 1 ->
                        maintenanceMgmt.serveFront();
                    case 2 -> {
                        System.out.println();
                        //maintenanceMgmt.manageCompletion();
                    }
                    case 3 -> {
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 3.");
            }

        } while (ch != 3);
    }

    public static void main(String[] args) throws ParseException {
        
        Facility badmintonCourt1 = new Facility("B001", "Badmintion Court 1", "Badmintion", true);
        Facility badmintonCourt2 = new Facility("B002", "Badmintion Court 2", "Badmintion", true);
        Facility badmintonCourt3 = new Facility("B003", "Badmintion Court 3", "Badmintion", true);
        Facility badmintonCourt4 = new Facility("B004", "Badmintion Court 4", "Badmintion", true);
        Facility badmintonCourt5 = new Facility("B005", "Badmintion Court 5", "Badmintion", true);
        Facility tennisCourt1 = new Facility("T001", "Tennie Court 1", "Tennis", true);
        Facility tennisCourt2 = new Facility("T002", "Tennie Court 2", "Tennis", true);
        Facility tennisCourt3 = new Facility("T003", "Tennie Court 3", "Tennis", true);
        Facility tennisCourt4 = new Facility("T004", "Tennie Court 4", "Tennis", true);
        Facility tennisCourt5 = new Facility("T005", "Tennie Court 5", "Tennis", true);
      
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//        Maintenance maintenance1 = new Maintenance("B001", "Replace", "Broken net", formatter.parse("2021-04-22"));
//        Maintenance maintenance2 = new Maintenance("T005", "Repair", "Broken fence", formatter.parse("2021-04-25"));
//        Maintenance maintenance3= new Maintenance("B004", "Repair", "Broken net", formatter.parse("2021-04-12"));
//        GregorianCalendar requestDate = new GregorianCalendar();
//        Date now = requestDate.getTime();
//        maintenance1.setRequestDate(now);
//        maintenance2.setRequestDate(now);
//        maintenance3.setRequestDate(now);
//        
//        maintenanceMgmt.appointmentQueue.enqueue(maintenance1);
//        maintenanceMgmt.appointmentQueue.enqueue(maintenance2);
//        maintenanceMgmt.appointmentQueue.enqueue(maintenance3);
        
        MaintenanceManagementMenu();
    }
}
