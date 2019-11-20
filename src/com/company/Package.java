package com.company;



public abstract class Package {
    public double price;
    public double weight;
    public String track;



    private boolean canContain;
    private boolean canBeIn;
    private double place;

    public void set_canContain(boolean B){
        this.canContain = B;
    }

    public void set_canBeIn(boolean B){
        this.canBeIn = B;
    }

    public void set_place(double I){
        this.place = I;
    }

    public double get_place(){
        return this.place;
    }

    public boolean get_CanContain(){
        return this.canContain;
    }

    public boolean get_CanBeIn(){
        return this.canBeIn;
    }


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

    public void setStartData(boolean _canContain, boolean _canBeIn, double _place){
        this.set_canContain(_canContain);
        this.set_canBeIn(_canBeIn);
        this.set_place(_place);
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
