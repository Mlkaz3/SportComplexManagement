package client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EquipmentDriver {
    public static EquipmentManagement equipmentManagement = new EquipmentManagement();
    
//    public static void EquipmentMenu() {
//        int equipChoice = 0;
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
//                equipChoice = input.nextInt();
//                
//                EquipmentManagementMenu(equipChoice);
//
//            } catch (InputMismatchException e) {
//                System.out.println();
//                System.out.println("Error. Please enter an integer value within 1 and 4.");
//            }
//
//        } while (equipChoice != 4);
//    }
//    
    public static void EquipmentManagementMenu() {
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
                        //stockManagement();
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
    
    
    
    public static void main(String[] args) {
        EquipmentManagementMenu();
    }
}
