package org.shenmeng;

import java.util.Scanner;

public class SameDayDelivery extends DeliveryMenu {

    private String towntype;
    private double weight;
    private static double chargedelivery2;
    private static double totalchargedilivery2[] = new double[3];
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

            SameDayDelivery sameDayDelivery =new SameDayDelivery();
            sameDayDelivery.displayTable();
            sameDayDelivery.inputDataDelivery();

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
        System.out.printf("\nWeight\t\t\t\tLocal Town(L)\t\t\t\t\t\t\t\tCross Town(C)\n\t\t");
        int line = 1;
        while (line <= 80) {
            System.out.printf("%c", 45);
            line++;
        }
        System.out.printf("\n\t\t  Domestic Charge\tSurcharge\tTotal\t  Domestic Charge\tSurcharge\tTotal\n");
        line();
        System.out.printf("\nBelow 500gm\t\t4.90\t\t  6.00\t\t10.90\t\t   5.40\t\t\t  7.50\t\t12.90\n");
        System.out.printf("500gm-750gm\t\t5.70\t\t  6.00\t\t11.70\t\t   6.40\t\t\t  7.50\t\t13.90\n");
        System.out.printf("750gm-1kg\t\t6.50\t\t  6.00\t\t12.50\t\t   7.40\t\t\t  7.50\t\t14.90\n");
        line();
    }


    @Override
    void inputDataDelivery() {
        Scanner input=new Scanner(System.in);

        int customer;

        for(customer=0;customer<totalchargedilivery2.length;customer++){

            /*Display Customer*/
            System.out.printf("\n\nCustomer %d:\n",customer+1);
            System.out.printf("----------------------\n");

            totalchargedilivery2[customer]=0;

            /*Input First Town Type*/
            System.out.printf("\nEnter your town-type ( L/C/X to quit):");
            towntype=input.next();
            towntype=towntype.toUpperCase();

            /*Loop*/
            while(!towntype.equals("X")){

                /*Input Weight*/
                System.out.printf("Enter your weight\t\t\t\t\t\t:");
                weight=input.nextDouble();
                while(weight>1000){
                    System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
                    System.out.printf("Enter your weight\t\t\t\t\t\t:");
                    weight=input.nextDouble();
                }while(weight<=1000){
                    break;
                }

                chargedelivery2=calChargeDelivery();

                /*Display Charges*/
                System.out.printf("Charges in %s is RM%.2f\n",towntype,chargedelivery2);

                /*Accuumulate Total Charge*/
                totalchargedilivery2[customer]+=chargedelivery2;

                /*Input Next Town Type*/
                System.out.printf("\nEnter your town-type ( L/C/X to quit):");
                towntype=input.next();
                towntype=towntype.toUpperCase();
            }
            System.out.printf("All charges in RM%.2f\n",totalchargedilivery2[customer]);
        }
    }

    @Override
    double calChargeDelivery() {
        double surcharge=0;
        double domestic_charge=0;

        switch(towntype){

            case "L":if(weight<=500){
                domestic_charge=4.90;
                surcharge=6.00;
            }if(weight>500&&weight<=750){
                domestic_charge=5.70;
                surcharge=6.00;
            }if(weight>750&&weight<=1000){
                domestic_charge=6.50;
                surcharge=6.00;
            }towntype="Local Town";
            break;
            case "C":if(weight<=500){
                domestic_charge=5.40;
                surcharge=7.50;
            }if(weight>500&&weight<=750){
                domestic_charge=6.40;
                surcharge=7.50;
            }if(weight>750&&weight<=1000){
                domestic_charge=7.40;
                surcharge=7.50;
            }towntype="Cross Town";
            break;
        }
        chargedelivery2=domestic_charge+surcharge;
        return chargedelivery2;
    }

    public static double[] getTotalchargedilivery2() {
        return totalchargedilivery2;
    }
}
