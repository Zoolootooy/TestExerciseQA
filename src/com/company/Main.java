package com.company;

public class Main {

    public static void main(String[] args) {
        int randSize = 0;
        randSize = 20 + (int)(Math.random()*51);
        int choice;
        Receipts R = new Receipts();

        for (int i = 0; i < randSize; i++){
            choice = 0 + (int)(Math.random()*6);

            switch (choice){
                case 0:
                    R.add_Corrugated_Box();
                    break;

                case 1:
                    R.add_Big_Corrugated_Box();
                    break;

                case 2:
                    R.add_Cardboard_Envelope();
                    break;

                case 3:
                    R.add_Polypropylene_Bag();
                    break;

                case 4:
                    R.add_Bubble_Wrap();
                    break;

                case 5:
                    R.add_Wooden_Box();
                    break;
            }
        }

        System.out.println("Файл с поступлениями: D://Log-in.txt");
        System.out.println("Файл с выводом сформированных посылок: D://Log-out.txt");
        R.createLog_In();
        R.Form();
    }
}
