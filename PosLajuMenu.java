package org.shenmeng;

import java.util.Scanner;

public class PosLajuMenu extends Line{


    public static void main(String[] args) {

        choice();

    }

    public static void choice(){

        Line line1 = new Line();
        Scanner input=new Scanner(System.in);
        int choice;

        /*Display Main Menu*/
        System.out.printf("Main Menu\n");

        /*Display Main Menu*/
        System.out.printf("\n1. Next-Day Delivery\n");
        System.out.printf("2. Same-Day Delivery\n");
        System.out.printf("3. Prepaid Box & Envelope\n");
        System.out.printf("4. Pos Ekspres\n");
        System.out.printf("5. Receipt\n");
        System.out.printf("6. Exit\n\n");

        System.out.printf("Please select your choice\t:");
        choice=input.nextInt();
        while(choice>6){
            System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
            System.out.printf("Please select your choice:");
            choice=input.nextInt();
        }while(choice<=6){
            break;
        }
        selectChoice(choice);
    }

    public static void selectChoice(int choice){

    NextDayDelivery nextdaydelivery = new NextDayDelivery();
    SameDayDelivery samedaydelivery = new SameDayDelivery();
    PrepaidBoxEnvelope prepaidboxenvelope = new PrepaidBoxEnvelope();
    PosEkspress posekspress = new PosEkspress();
    Receipt receipt = new Receipt();

        if(choice==1){
            nextdaydelivery.selectchoice();
        }if (choice==2){
            samedaydelivery.selectchoice();
        }if(choice==3){
            prepaidboxenvelope.selectchoice();
        }if(choice==4){
            posekspress.selectchoice();
        }if(choice==5){
            receipt.receipt();
        }if(choice==6){
            System.out.printf("Thank You for Using Our System.\n");
        }
    }

}
