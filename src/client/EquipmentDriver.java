package client;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EquipmentDriver {
    public static EquipmentManagement equipmentManagement = new EquipmentManagement();
    
//    public static void EquipmentMenu() {
//        int ch = 0;
//        do {
//            Scanner input = new Scanner(System.in);
//            try {
//                System.out.println();
//                System.out.println("***************************************************");
//                System.out.println("*                  Equipment Type                 *");
//                System.out.println("*                                                 *");
//                System.out.println("*    [1] Tennis                                   *");
//                System.out.println("*    [2] Badminton                                *");
//                System.out.println("*    [3] Squash                                   *");
//                System.out.println("*    [4] Back                                     *");
//                System.out.println("*                                                 *");
//                System.out.println("***************************************************");
//                System.out.println();
//
//                System.out.print("Please select your choice: ");
//                ch = input.nextInt();
//                
//                switch (ch) {
//                    case 1:
//                        equipmentManagement.setStackType(ch);
//                        EquipmentManagementMenu(ch);
//                        break;
//                    case 2:
//                        equipmentManagement.setStackType(ch);
//                        EquipmentManagementMenu(ch);
//                        break;
//                    case 3:
//                        equipmentManagement.setStackType(ch);
//                        EquipmentManagementMenu(ch);
//                        break;
//                    case 4:
//                        break;
//                    default:
//                        System.out.println();
//                        System.out.println("Error. Please select a correct choice.");
//                        break;
//                }
//
//            } catch (InputMismatchException e) {
//                System.out.println();
//                System.out.println("Error. Please enter an integer value within 1 and 4.");
//            }
//
//        } while (ch != 4);
//    }
//    
    public static void EquipmentManagementMenu() throws ParseException {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*               Equipment Management              *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] View Equipment                           *");
                System.out.println("*    [2] Borrow Equipment                         *");
                System.out.println("*    [3] Return Equipment                         *");
                System.out.println("*    [4] Stock Management                         *");
                System.out.println("*    [5] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println();
                        equipmentManagement.displayStack();
                        break;
                    case 2:
                        System.out.println();
                        equipmentManagement.borrowEquipment();
                        break;
                    case 3:
                        System.out.println();
                        equipmentManagement.returnEquipment();

                        break;
                    case 4:
                        System.out.println();
                        stockManagementMenu();
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
    
    public static void stockManagementMenu() {
        int ch = 0;
        do {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println();
                System.out.println("***************************************************");
                System.out.println("*                 Stock Management                *");
                System.out.println("*                                                 *");
                System.out.println("*    [1] Stock In                                 *");
                System.out.println("*    [2] Clear All Broken Equipment               *");
                System.out.println("*    [4] Back                                     *");
                System.out.println("*                                                 *");
                System.out.println("***************************************************");
                System.out.println();

                System.out.print("Please select your choice: ");
                ch = input.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println();
                        equipmentManagement.stockIn();
                        break;
                    case 2:
                        System.out.println();
                        equipmentManagement.clearAll();
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
                System.out.println("Error. Please enter an integer value within 1 and 3.");
            }

        } while (ch != 3);
    }
    
    public static void main(String[] args) throws ParseException {
        //EquipmentManagementMenu();
        EquipmentManagementMenu();
    }
}
