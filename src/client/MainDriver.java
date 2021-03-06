/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.ArrayPriorityQueue;
import adt.PriorityComparator;
import adt.PriorityQueueInterface;
import entity.Equipment;
import entity.Maintenance;
import entity.ReservationRecord;
import entity.User;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author winnieyap
 */
public class MainDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO TARUC SPORT COMPLEX");
        System.out.println("");
        MainPage();

    }

    public static void MainPage() {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
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
                        Facility();
                        break;
                    case 2:
                        System.out.println();
                        Equipment();
                        break;
                    case 3:
                        System.out.println();
                        Maintenance();
                        break;
                    case 4:
                        System.out.println();
                        Others();
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

    private static void Facility() {
        int ch = 0;
        boolean invalidInput;
        do {
            invalidInput = false;
            Scanner input = new Scanner(System.in);

            System.out.println("\nFACILITIES");
            System.out.println("----------");
            System.out.println("View Slot");
            System.out.println("Reserve Slot");
            System.out.println("Check In Slot");
            System.out.println("Cancel Slot");
            try {
                System.out.print("Please select your choice: ");
                ch = input.nextInt();
                System.out.println("");

                switch (ch) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        break;
                    default:
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        System.out.println();
                }

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 3");
                System.out.println();
                invalidInput = true;
            }
        } while (ch != 3 || invalidInput);
    }

    private static void Equipment() {
        int ch = 0;
        boolean invalidInput;
        do {
            invalidInput = false;
            Scanner input = new Scanner(System.in);

            System.out.println("\nEQUIPMENT");
            System.out.println("---------");
            System.out.println("(1) View Equipment");
            System.out.println("(2) Borrow");
            System.out.println("(3) Return");

            try {
                System.out.print("Please select your choice: ");
                ch = input.nextInt();
                System.out.println("");

                switch (ch) {
                    case 1:
                        System.out.println("Havent implement gomennasaaii");
                        break;
                    case 2:
                        //when user wanna borrow stg 
                        //hardcode a equipment (user want)
                        Equipment equipment = new Equipment("Testing001", "Badminton Racquet", true, "23.00", "somewhere", "racquet");

                        //hardcode a user
                        User user = new User("taruc", "taruc1234", "admin", "0123568975");

                        //prompt user for what they wanna borrow
                        System.out.println("What do you wanna borrow?");
                        System.out.println("Badminton Racquet will be borrow. This is a hardcode.");
                        //String choice = input.next();

                        //check availability
                        if (equipment.getEquipmentStatus()) {
                            //if true
                            System.out.println("Racquet is available now.");
                            //prompt for duration
                            System.out.println("How long u wan to borrow? (in minutes)");
                            double duration = input.nextInt();

                            //user and validation
                            //this case no cause we hardcode
                            System.out.println("User Validation on going (5s)");
                            System.out.println("User Validation on going (4s)");
                            System.out.println("User Validation on going (3s)");
                            System.out.println("User Validation on going (2s)");
                            System.out.println("User Validation on going (1s)");

                            //add record
                            ReservationRecord record1 = new ReservationRecord(duration, user, equipment);
                            System.out.println("user1:" + user);
                            System.out.println("equipment1: " + equipment);
                            System.out.println("record1: " + record1);
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        System.out.println();
                }

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 3");
                System.out.println();
                invalidInput = true;
            }
        } while (ch != 3 || invalidInput);
    }

    private static void Maintenance() {
        int ch = 0;
        boolean invalidInput;

        //TO DO: serialize
        PriorityQueueInterface<Maintenance> schedule = new ArrayPriorityQueue<>(10, new PriorityComparator());

        do {
            invalidInput = false;
            Scanner input = new Scanner(System.in);

            System.out.println("\nMAINTENANCE");
            System.out.println("-----------");
            System.out.println("(1) Add");
            System.out.println("(2) Complete");
            System.out.println("(3) Cancel");
            System.out.println("(4) Manage");
            System.out.println("(5) Back");

            try {
                System.out.print("Please select your choice: ");
                ch = input.nextInt();
                System.out.println("");
                Scanner userInput = new Scanner(System.in);

                switch (ch) {
                    case 1:
                        Maintenance maintenance = new Maintenance();

                        System.out.print("\nFacility ID: ");
                        maintenance.setFacility(userInput.nextLine());
                        System.out.print("Maintenance type: ");
                        maintenance.setMaintenanceType(userInput.nextLine());
                        System.out.print("Maintenance description: ");
                        maintenance.setMaintenanceDesc(userInput.nextLine());
                        System.out.print("Maintenance cost: ");
                        maintenance.setMaintenanceCost(userInput.nextDouble());

                        schedule.enqueue(maintenance);
                        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Maintenance cost");
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println(schedule);

                        break;
                    case 2:
                        System.out.println("FIFO, first record will be removed");
                        schedule.dequeue();
                        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Maintenance cost");
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println(schedule);
                        break;
                    case 3:
                        System.out.println("Cancel a schedule: ");
                        int remove = userInput.nextInt();
                        System.out.println(schedule.remove(remove) + " is cancelled.");
                        break;
                    case 4:
                        System.out.println("Maintenance History");
                        System.out.println("");
                        System.out.printf("%-10s %-15s %-25s %-20s\n", "Facility ID | ", "Maintenance type | ", "Maintenance description | ", "Maintenance cost");
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println(schedule);
                        break;
                    default:
                        System.out.println();
                        System.out.println("Error. Please select a correct choice.");
                        System.out.println();
                }

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Error. Please enter an integer value within 1 and 3");
                System.out.println();
                invalidInput = true;
            }
        } while (ch != 5 || invalidInput);
    }

    private static void Others() {
        String ch = "";
        String selection = "";
        boolean invalidInput;
        //do {
        invalidInput = false;
        Scanner input = new Scanner(System.in);

        //when enter usage log will display record on the day only to ease staff view
        System.out.println("");
        System.out.println("");
        System.out.println("                                                                                                          Date: ");
        System.out.println("                                                                                                          Time: ");
        System.out.println("                                                                                                          Day : ");
        System.out.println("\n                                                       RESERVATION REPORT LOG");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("RDate       RID        Name      Category           ReservedStartTime     ReservedEndTime     CheckedInTime       CheckOutTime    Status");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("12/2/21     R0000001   Winnie    Facilities-Hall    01:25PM               02:25PM             01:26PM             02:20PM           G   ");
        System.out.println("13/2/21     R0000002   Lin       Facilities-Hall    05:25PM               06:25PM             06:00PM             06:25PM           L   ");
        System.out.println("");

        System.out.println("B. Back");
        System.out.println("F. Functions");//setting is for filtering and generate usage report for each facilities

        ch = input.nextLine();
        if ("F".equals(ch)) {
            System.out.println("");
            System.out.println("VR. View First Row Details ");
            System.out.println("FR. Filter Report based on:-");
            System.out.println("UR. Usage Report");

            selection = input.nextLine();
            if ("VR".equals(selection)) {
                System.out.println("IT GONNA PRINT FIRST ROW");

            } else if ("FR".equals(selection)) {
                System.out.println("DT - Date Time");
                System.out.println("UI - User ID");
                System.out.println("FA - Facilites");
                System.out.println("EQ - Equipment");
                System.out.println("ST - Status");
            }
            else{
                System.out.println("USAGE REPORT");
                System.out.println("duration : 01/01/2021 - 01/03/2021");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Equipment");
                System.out.println("No  Items                Category       Times Borrowing   Percentage");
                System.out.println("1.  Badminton Racquet    Racquet            100             44.4%");
                System.out.println("2.  Squash Racquet       Racquet            65              28.9%");
                System.out.println("3.  Tennis Ball          Ball               60              26.7%");
                System.out.println("---------------------------------------------------------------------");
                System.out.println("                                      Sum   225             100%    ");
                System.out.println("======================================================================");
                System.out.println("");
                System.out.println("Facilities");
            }

        } else {
            //end this process
        }

//            try {
//                System.out.print("Please select your choice: ");
//                ch = input.nextInt();
//                System.out.println("");
//
//                switch (ch) {
//                    case 1:
//
//                        break;
//                    case 2:
//
//                        break;
//                    case 3:
//                        break;
//                    default:
//                        System.out.println();
//                        System.out.println("Error. Please select a correct choice.");
//                        System.out.println();
//                }
//
//            } catch (InputMismatchException e) {
//                System.out.println();
//                System.out.println("Error. Please enter an integer value within 1 and 3");
//                System.out.println();
//                invalidInput = true;
//            }
        //} while (ch != 3 || invalidInput);
    }
}
