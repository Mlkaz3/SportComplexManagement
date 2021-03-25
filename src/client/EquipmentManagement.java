package client;

import adt.ArrayStack;
import adt.StackInterface;
import adt.ArrayStackWithIteratorInterface;
import entity.Equipment;
import java.util.Iterator;
import java.util.Scanner;

public class EquipmentManagement {

    StackInterface<Equipment> equipmentStack;

    Scanner input = new Scanner(System.in);
    //StackInterface<Equipment> badmintonStack = new ArrayStack<>();
    //StackInterface<Equipment> squashStack = new ArrayStack<>();

    public EquipmentManagement() {
        equipmentStack = new ArrayStack<>();
    }

//    public void checkEmpty(StackInterface<Equipment> stackChoice) {
//        if(stackChoice.isEmpty());
//    }
//    public void setStack(int equipType) {
//        //set stack according to user choice.
//    }
    public void displayStack() {
        Iterator<Equipment> it = equipmentStack.getIterator();

        if (equipmentStack.isEmpty()) {
            System.out.println("Sorry. There are no racquet left.");
        } else {
            System.out.println("                                                            Tennis");
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20s\n",
                    "Equipment ID", "Equipment Brand", "Equipment Status", "Equipment Price", "Equipment Location", "Equipment Type");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println("There are currently " + equipmentStack.size() + " in stock.");
        }
    }

    public void borrowEquipment() {
        if (equipmentStack.isEmpty()) {
            System.out.println("Sorry. There are no racquet left.");
        } else {
            System.out.print("Enter Quantity : ");
            int qty = input.nextInt();

            if (equipmentStack.size() < qty) {
                System.out.println("Insufficient racquet.");
                System.out.println("There are only " + equipmentStack.size() + " racquet currently.");
            } else {
                for (int i = 0; i < qty; i++) {
                    equipmentStack.pop();
                }
            }
        }
    }

    public void returnEquipment() {
        System.out.print("Enter Quantity : ");
        String inputQty = input.nextLine();
        int qty = Integer.parseInt(inputQty);

        for (int i = 0; i < qty; i++) {
            Equipment equipment = new Equipment();

            //System.out.println("Equipment To Return : ");
            System.out.print("\nEquipment ID : ");
            equipment.setEquipmentID(input.nextLine());

            System.out.print("Equipment Brand : ");
            equipment.setEquipmentBrand(input.nextLine());

            System.out.print("Equipment Price : ");
            equipment.setEquipmentPrice(input.nextLine());

            System.out.print("Equipment Location : ");
            equipment.setEquipmentLocation(input.nextLine());

            System.out.print("Equipment Type : ");
            equipment.setEquipmentType(input.nextLine());

            equipment.setEquipmentStatus(true);
            equipmentStack.push(equipment);

            System.out.println("Equipment Returned.");
        }

    }

    
    public void stockIn() {
        Equipment e1 = new Equipment();
    }
}
