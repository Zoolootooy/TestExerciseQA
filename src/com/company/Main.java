package com.company;

public class Main {

    public static void main(String[] args) {
        //создание рандомного размера от 20 до 100 штук упаковок на вход
        int randSize = 0;
        randSize = 20 + (int)(Math.random()*81);

        //создание переменной для выбора случайного типа посылки
        int choice;

        //Создание объекта-поступления
        Receipts R = new Receipts();

        for (int i = 0; i < randSize; i++){
            choice = 0 + (int)(Math.random()*6);

            switch (choice){
                //добавление коробки из гофрокартона в поступление
                case 0:
                    R.add_Corrugated_Box();
                    break;

                //добавление большой коробки из гофрокартона в поступление
                case 1:
                    R.add_Big_Corrugated_Box();
                    break;

                //добавление картонного конверта в поступление
                case 2:
                    R.add_Cardboard_Envelope();
                    break;

                //добавление полипропиленового мешка в поступление
                case 3:
                    R.add_Polypropylene_Bag();
                    break;

                //добавление пузырчатой упаковки в поступление
                case 4:
                    R.add_Bubble_Wrap();
                    break;

                //добавление деревянного ящика в поступление
                case 5:
                    R.add_Wooden_Box();
                    break;
            }
        }

        System.out.println("Файл с поступлениями: D://Log-in.txt");
        System.out.println("Файл с выводом сформированных посылок: D://Log-out.txt");

        //создание файла с поступлениями
        R.createLog_In();

        //формирование из поступивших упаковок готовых к отправке деревянных ящиков
        R.Form();
    }
}
