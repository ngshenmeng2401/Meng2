package org.shenmeng;

import java.util.Scanner;

public class Receipt extends PosLajuMenu {

    private static NextDayDelivery nextdaydelivery = new NextDayDelivery();
    private static SameDayDelivery samedaydelivery = new SameDayDelivery();
    private static PrepaidBoxEnvelope prepaidboxenvelope = new PrepaidBoxEnvelope();
    private static PosEkspress posekspress = new PosEkspress();
    private static PosLajuMenu posLajuMenu = new PosLajuMenu();
    private static double totalchargedilivery1[] = nextdaydelivery.getTotalchargedilivery1();
    private static double totalchargedilivery2[] = samedaydelivery.getTotalchargedilivery2();
    private static double totalchargedilivery3[] = prepaidboxenvelope.getTotalchargedilivery3();
    private static double totalchargedilivery4[] = posekspress.getTotalchargedilivery4();

    public static void receipt() {

        Scanner input = new Scanner(System.in);
        int customer, line, choice = 0;
        double grandtotal = 0;

        /*Display Menu*/
        System.out.printf("1. Display Receipt\n");
        System.out.printf("2. Return to Main Menu\n");

        System.out.printf("Enter your choice\t:");
        choice = input.nextInt();
        while (choice > 2) {
            System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
            System.out.printf("Enter your choice\t:");
            choice = input.nextInt();
        }
        while (choice <= 2) {
            break;
        }

        if (choice == 1) {

            for (customer = 0; customer < totalchargedilivery1.length; customer++) {

                /*Display Customer*/
                System.out.printf("\nCustomer %d:\n", customer + 1);
                System.out.printf("------------------\n");

                //Calculate Grand Total
                grandtotal = totalchargedilivery1[customer] + totalchargedilivery2[customer] + totalchargedilivery3[customer] + totalchargedilivery4[customer];

                //Display Receipt
                System.out.printf("Total Charge:\n");
                System.out.printf("Next-Day Delivery\t\t\tRM%10.2f\n", totalchargedilivery1[customer]);
                System.out.printf("Same-Day Delivery\t\t\tRM%10.2f\n", totalchargedilivery2[customer]);
                System.out.printf("Prepaid Box & Envelope\t\tRM%10.2f\n", totalchargedilivery3[customer]);
                System.out.printf("Pos Ekspres\t\t\t\t\tRM%10.2f\n", totalchargedilivery4[customer]);
                line = 1;
                while (line <= 60) {
                    System.out.printf("%c", 45);
                    line++;
                }
                System.out.printf("\nTotal \t\t\t\t\t\tRM%10.2f\n\n", grandtotal);

            }
            System.out.printf("Enter your choice\t:");
            choice = input.nextInt();
            while (choice > 2) {
                System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
                System.out.printf("Enter your choice\t:");
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
}
