package org.shenmeng;

import java.util.Scanner;

public class PosEkspress extends DeliveryMenu{

    private int quantity;
    private String ItemType;
    private double weight;
    private static double chargedelivery4;
    private static double totalchargedilivery4[] = new double[3];
    @Override
    void selectchoice() {
        PosLajuMenu posLajuMenu = new PosLajuMenu();
        Scanner input = new Scanner(System.in);
        int choice;

        /*Display Menu*/
        System.out.print("1. Input your data\n");
        System.out.print("2. Return to Main Menu\n");
        line();
        System.out.print("\nEnter your choice\t\t\t:");
        choice = input.nextInt();
        while (choice > 2) {
            System.out.print("Invalid Input!!! Please key in correct data!!!\n");
            System.out.print("Enter your choice\t:");
            choice = input.nextInt();
        }
        while (choice <= 2) {
            break;
        }
        if (choice == 1) {

            PosEkspress posekspress = new PosEkspress();
            posekspress.displayTable();
            posekspress.inputDataDelivery();

            System.out.print("\nEnter your choice\t\t\t:");
            choice = input.nextInt();
            while (choice > 2) {
                System.out.print("Invalid Input!!! Please key in correct data!!!\n");
                System.out.print("Enter your choice\t:");
                choice = input.nextInt();
            }
            while (choice <= 2) {
                break;
            }
        }
        if (choice == 2) {
            posLajuMenu.choice();
        }
    }

    @Override
    void displayTable() {
        /*Display Table*/
        line();
        System.out.printf("\nJenis\t\t\t  LG\t\t\t\t  LE(C5)\t\t\t LD(B4)\t\t\t     LK\n");
        line();
        System.out.printf("\nSaiz\t\t   220mm*110mm\t\t\t229mm*162mm\t\t  353mm*250mm\t\t 340mm*250mm\n\n");
        System.out.printf("Berat Max\t\t 100g\t\t\t\t   250g\t\t\t\t  500g\t\t\t\t1000g\n\n");
        System.out.printf("Berat Max\t\t 3mm\t\t\t\t   5mm\t\t\t\t  10mm\t\t\t\t25mm\n\n");
        System.out.printf("Harga\t\t\tRM3.18\t\t\t\t  Rm3.71\t\t\t RM4.77\t\t\t    RM7.42\n");
        line();
    }

    @Override
    void inputDataDelivery() {
        Scanner input = new Scanner(System.in);

        /*Declaration*/
        int customer;

        for (customer = 0; customer < totalchargedilivery4.length; customer++) {

            /*Display Customer*/
            System.out.printf("\n\nCustomer %d:\n", customer + 1);
            System.out.printf("----------------------\n");

            totalchargedilivery4[customer] = 0;

            /*Input First Item Type*/
            System.out.printf("\nEnter your item (LG/LE/LD/LK/X to quit)):");
            ItemType = input.next();
            ItemType = ItemType.toUpperCase();

            /*Loop*/
            while (!ItemType.equals("X")) {

                /*Input Quantity*/
                System.out.printf("Enter your quantity\t\t\t\t\t:");
                quantity = input.nextInt();

                /*Input Weight*/
                System.out.printf("Enter your weight\t\t\t\t\t:");
                weight = input.nextDouble();
                while (weight > 1000) {
                    System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
                    System.out.printf("Enter your weight\t\t:");
                    weight = input.nextDouble();
                }
                while (weight <= 1000) {
                    break;
                }

                chargedelivery4=calChargeDelivery();

                /*Display Charges*/
                System.out.printf("Charges in %s is RM%.2f\n", ItemType, chargedelivery4);

                /*Accumulate Total Charge*/
                totalchargedilivery4[customer] += chargedelivery4;

                /*Input First Item Type*/
                System.out.printf("\nEnter your item (LG/LE/LD/LK/X to quit)):");
                ItemType = input.next();
                ItemType = ItemType.toUpperCase();

            }
            System.out.printf("All charges in RM%.2f\n", totalchargedilivery4[customer]);
        }
    }
    @Override
    double calChargeDelivery() {
            double price=0;
            if(weight<=100){
                price=3.18;
            }if(weight>100&&weight<=250){
                price=3.71;
            }if(weight>250&&weight<=500){
                price=4.77;
            }if(weight>500&&weight<=1000){
                price=7.42;
            }
            chargedelivery4=price*quantity;
            return chargedelivery4;
    }

    public static double[] getTotalchargedilivery4() {
        return totalchargedilivery4;
    }
}



