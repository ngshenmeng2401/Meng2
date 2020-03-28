package org.shenmeng;

import java.util.Scanner;

public class NextDayDelivery extends DeliveryMenu{

    private int zone;
    private String packagetype;
    private double weight;
    private static double chargedelivery1;
    private static double totalchargedilivery1[] = new double[3];

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

            NextDayDelivery nextDayDelivery = new NextDayDelivery();
            nextDayDelivery.displayTable();
            nextDayDelivery.inputDataDelivery();

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
        System.out.print("\n\t\t\tDocument (below 2kg)\t\t\t\tParcel(above 2kg)\n");
        line();
        System.out.print("\n\t   First 500gm\t   Subsequent 250gm\t\t2.001-2.5kg\t\tSubsequent 500gm\n");
        line();
        System.out.print("\nZone 1\t\t4.90\t\t\t0.80\t\t\t\t10.50\t\t\t0.50\n");
        System.out.print("\nZone 2\t\t5.40\t\t\t1.00\t\t\t\t16.00\t\t\t2.00\n");
        System.out.print("\nZone 3\t\t6.90\t\t\t1.50\t\t\t\t21.00\t\t\t3.00\n");
        System.out.print("\nZone 4\t\t7.40\t\t\t1.50\t\t\t\t26.00\t\t\t3.50\n");
        System.out.print("\nZone 5\t\t7.90\t\t\t2.00\t\t\t\t31.00\t\t\t4.00\n");
        line();
    }

    @Override
    void inputDataDelivery() {
        Scanner input = new Scanner(System.in);

        /*Declaration*/
        int customer;

        for (customer = 0; customer < totalchargedilivery1.length; customer++) {

            /*Display Customer*/
            System.out.printf("\nCustomer %d:\n", customer + 1);
            System.out.print("----------------------\n");

            totalchargedilivery1[customer] = 0;

            /*Input First Package Type*/
            System.out.print("\nEnter your package type (D=Document & P=Parcel):");
            packagetype = input.next();
            packagetype = packagetype.toUpperCase();

            /*Loop*/
            while (!packagetype.equals("X")) {

                /*input weight and zone*/
                System.out.print("Enter your weight\t\t\t:");
                weight = input.nextDouble();
                System.out.print("Enter your zone\t\t\t\t:");
                zone = input.nextInt();
                while (zone > 5) {
                    System.out.print("Invalid Input!!! Please key in correct data!!!\n");
                    System.out.print("Enter your zone\t\t\t\t:");
                    zone = input.nextInt();
                }
                while (zone <= 5) {
                    break;
                }

                chargedelivery1=calChargeDelivery();

                /*Display Charges*/
                System.out.printf("Charges in %s is RM%.2f\n", packagetype, chargedelivery1);

                /*Accumulate Total Charge*/
                totalchargedilivery1[customer] += chargedelivery1;

                /*Input First Package Type*/
                System.out.print("\nEnter your package type (D=Document & P=Parcel):");
                packagetype = input.next();
                packagetype = packagetype.toUpperCase();
            }
            System.out.printf("All charges in RM%.2f\n", totalchargedilivery1[customer]);
        }
    }
    @Override
    double calChargeDelivery() {
        switch (zone) {
        case 1:
        if (weight <= 2000) {
            if (weight <= 2000) {
                chargedelivery1 = 4.90 + (weight - 500) / 250 * 0.80;
            }
            if (weight <= 500) {
                chargedelivery1 = 4.90;
            }packagetype="DOCUMENT";
        }
        if (weight > 2000) {
            if (weight <= 2500) {
                chargedelivery1 = 10.50;
            }
            if (weight > 2500) {
                chargedelivery1 = 10.50 + (weight - 2500) / 500 * 0.50;
            }packagetype="PARCEL";
        }break;
        case 2:
        if (weight <= 2000) {
            if (weight <= 2000) {
                chargedelivery1 = 5.40 + (weight - 500) / 250 * 1.00;
            }
            if (weight <= 500) {
                chargedelivery1 = 5.40;
            }packagetype="DOCUMENT";

        }
        if (weight > 2000) {
            if (weight <= 2500) {
                chargedelivery1= 16.00;
            }
            if (weight > 2500) {
                chargedelivery1= 16.00 + (weight - 2500) / 500 * 2.00;
            }packagetype="PARCEL";
        }break;
        case 3:
        if (weight <= 2000) {
            if (weight <= 2000) {
                chargedelivery1 = 6.90 + (weight - 500) / 250 * 1.50;
            }
            if (weight <= 500) {
                chargedelivery1 = 6.90;
            }packagetype="DOCUMENT";
        }
        if (weight > 2000) {
            if (weight <= 2500) {
                chargedelivery1 = 21.00;
            }
            if (weight > 2500) {
                chargedelivery1 = 21.00 + (weight - 2500) / 500 * 3.00;
            }packagetype="PARCEL";
        }break;
        case 4:
        if (weight <= 2000) {
            if (weight <= 2000) {
                chargedelivery1 = 7.40 + (weight - 500) / 250 * 1.50;
            }
            if (weight <= 500) {
                chargedelivery1 = 7.40;
            }packagetype="DOCUMENT";
        }
        if (weight > 2000) {
            if (weight <= 2500) {
                chargedelivery1 = 26.00;
            }
            if (weight > 2500) {
                chargedelivery1= 26.00 + (weight - 2500) / 500 * 3.50;
            }packagetype="PARCEL";
        }break;
        case 5:
        if (weight <= 2000) {
            if (weight <= 2000) {
                chargedelivery1= 7.90 + (weight - 500) / 250 * 2.00;
            }
            if (weight <= 500) {
                chargedelivery1= 7.90;
            }packagetype="DOCUMENT";
        }
        if (weight > 2000) {
            if (weight <= 2500) {
                chargedelivery1= 31.00;
            }
            if (weight > 2500) {
                chargedelivery1= 31.00 + (weight - 2500) / 500 * 4.00;
            }packagetype="PARCEL";
        }break;

    }return chargedelivery1;
    }

    public static double[] getTotalchargedilivery1() {

        return totalchargedilivery1;
    }

}

