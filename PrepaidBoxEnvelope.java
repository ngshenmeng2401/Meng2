package org.shenmeng;

import java.util.Scanner;

public class PrepaidBoxEnvelope extends DeliveryMenu {

    private int quantity;
    private String ItemType;
    private double weight;
    private static double chargedelivery3;
    private static double totalchargedilivery3[] = new double[3];
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

            PrepaidBoxEnvelope prepaidboxenvelope = new PrepaidBoxEnvelope();
            prepaidboxenvelope.displayTable();
            prepaidboxenvelope.inputDataDelivery();

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
        System.out.printf("\nJenis\t\tEnvelope S (ES)\t\tEnvelope L (EL)\t\tPrepaid Box S (PS)\t\tPrepaid Box M (PM)\t\tPrepaid Box L (PL)\n");
        line();
        System.out.printf("\nSaiz\t\t280mm*200mm\t\t\t 380mm*320mm\t\t340mm*250mm*80mm\t    340mm*250mm*150mm\t   380mm*320mm*x200mm\n\n");
        System.out.printf("Berat Max\t\t500g\t\t\t\t1kg\t\t\t\t\t  2kg\t\t\t\t\t 5kg\t\t\t\t     10kg\n\n");
        System.out.printf("Harga\t\t   RM7.31\t\t\t  Rm10.49\t\t\t    RM13.78\t\t\t\t   RM21.20\t\t\t\t    RM31.80\n");
        line();
    }


    @Override
    void inputDataDelivery() {
        Scanner input=new Scanner(System.in);

        int customer;

        for(customer=0;customer<totalchargedilivery3.length;customer++){

            /*Display Customer*/
            System.out.printf("\nCustomer %d:\n",customer+1);
            System.out.printf("----------------------\n");

            totalchargedilivery3[customer]=0;

            /*Input First Item Type*/
            System.out.printf("\nEnter your item (ES/EL/PS/PM/PL/X to quit)\t:");
            ItemType=input.next()+input.nextLine();
            ItemType=ItemType.toUpperCase();

            /*Loop*/
            while(!ItemType.equals("X")){

                /*Input Quantity*/
                System.out.printf("Enter your quantity\t\t\t\t\t\t:");
                quantity=input.nextInt();

                /*Input Weight*/
                System.out.printf("Enter your weight\t\t\t\t\t\t:");
                weight=input.nextDouble();
                while(weight>10000){
                    System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
                    System.out.printf("Enter your weight\t\t\t\t\t\t:");
                    weight=input.nextDouble();
                }while(weight<=10000){
                    break;
                }

                chargedelivery3=calChargeDelivery();

                /*Display Charges*/
                System.out.printf("Charges in %s is RM%.2f\n",ItemType,chargedelivery3);

                /*Accumulate Total Charge*/
                totalchargedilivery3[customer]+=chargedelivery3;

                /*Input First Item Type*/
                System.out.printf("\nEnter your item (ES/EL/PS/PM/PL/X to quit)\t:");
                ItemType=input.next()+input.nextLine();
                ItemType=ItemType.toUpperCase();

            }
            System.out.printf("All charges in RM%.2f\n",totalchargedilivery3[customer]);
        }
    }

    @Override
    double calChargeDelivery() {
        double price=0;

        if(weight<=500){
            price=7.31;
            ItemType="Envelope S";
        }if(weight>500&&weight<=1000){
            price=10.49;
            ItemType="Envelope L";
        }if(weight>1000&&weight<=2000){
            price=13.78;
            ItemType="Prepaid Box S";
        }if(weight>2000&&weight<=5000){
            price=21.20;
            ItemType="Prepaid Box M";
        }if(weight>5000&&weight<=10000){
            price=31.80;
            ItemType="Prepaid Box L";
        }
        chargedelivery3=price*quantity;
        return chargedelivery3;
    }

    public static double[] getTotalchargedilivery3() {
        return totalchargedilivery3;
    }
}
