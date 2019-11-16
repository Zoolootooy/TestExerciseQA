package com.company;

public class Main {

    public static void main(String[] args) {
        int randSize = 20 + (int)(Math.random()*100);
        int choice;

        /*
        Corrugated_Box[] cb = new Corrugated_Box[100];
        Big_Corrugated_Box[] bcb = new Big_Corrugated_Box[100];
        Cardboard_Envelope[] ce = new Cardboard_Envelope[100];
        Polypropylene_Bag[] pb = new Polypropylene_Bag[100];
        Bubble_Wrap[] bw = new Bubble_Wrap[100];
        Wooden_Box[] wb = new Wooden_Box[100];
        */

        Receipts R = new Receipts();

        /**/
        R.add_Corrugated_Box();
        R.add_Big_Corrugated_Box();
        R.add_Big_Corrugated_Box();
        R.add_Cardboard_Envelope();
        R.add_Polypropylene_Bag();
        R.add_Bubble_Wrap();

        R.add_Wooden_Box();
        R.add_Wooden_Box();

        //R.showAllPackages();

        System.out.println(R.ExpectedPlace());
        System.out.println(R.ExpectedWooden_Boxes());
        R.showAllPackages();
        //R.Form();
        R.createLog_In();


        for (int i = 0; i < randSize; i++){
            choice = 0 + (int)(Math.random()*5);

            switch (choice){
                case 0:
                    break;

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;
            }
        }





    }
}
