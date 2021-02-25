/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

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
                System.out.println("*    [4] Others                                   *");
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
            System.out.println("View Equipment");
            System.out.println("Borrow");
            System.out.println("Return");

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

    private static void Maintenance() {
        int ch = 0;
        boolean invalidInput;
        do {
            invalidInput = false;
            Scanner input = new Scanner(System.in);

            System.out.println("\nMAINTENANCE");
            System.out.println("-----------");
            System.out.println("Add");
            System.out.println("Remove");
            System.out.println("Update");
            System.out.println("Manage");

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

    private static void Others() {
        int ch = 0;
        boolean invalidInput;
        do {
            invalidInput = false;
            Scanner input = new Scanner(System.in);

            System.out.println("\nOTHER");
            System.out.println("---------");
            System.out.println("View History");

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
}
