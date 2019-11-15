package com.company;

public class Main {

    public static void main(String[] args) {

        Wooden_Box wb = new Wooden_Box(true);
        Corrugated_Box cb = new Corrugated_Box(true);
        Big_Corrugated_Box bcb = new Big_Corrugated_Box(true);
        Cardboard_Envelope ce = new Cardboard_Envelope(true);

        System.out.println("Деревянный ящик:");
        System.out.println(wb.price);
        System.out.println(wb.track);
        System.out.println(wb.weight);


        System.out.println("\nКоробка из гофрокартона:");
        System.out.println(cb.price);
        System.out.println(cb.track);
        System.out.println(cb.weight);

        System.out.println("\nБольшая коробка из гофрокартона:");
        System.out.println(bcb.price);
        System.out.println(bcb.track);
        System.out.println(bcb.weight);

        System.out.println("\nКартонный конверт:");
        System.out.println(ce.price);
        System.out.println(ce.track);
        System.out.println(ce.weight);


    }
}
