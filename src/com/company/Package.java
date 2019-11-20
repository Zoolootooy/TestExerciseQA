package com.company;

//THIS IS:
//абстрактный класс-упаковка для описания общих полей и методов

public abstract class Package {
    public double price;
    public double weight;
    public String track;






    public double GetRandPrice(double min, double max){
        return (double)(min + (int) (Math.random() * max) + 0.25 * (0 + (int) (Math.random() * 4)));
    }

    public double GetRandWeight(double min, double max){
        return roundTo(min + (double) (Math.random() * max),2);
    }


    static double roundTo (double d, int precise) {
        d *= Math.pow(10, precise);
        d = Math.round(d);
        d /= Math.pow(10, precise);
        return (double)d;
    }



    public String GetRandTrack(){
        String S = new String();
        String alphabeth = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


        for (int i = 0; i < 14; i++){
            S += alphabeth.charAt((int)(0 + (int) (Math.random() * 36)));
        }

        return S;
    }
}
