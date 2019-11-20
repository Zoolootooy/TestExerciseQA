package com.company;

public class Wooden_Box extends Package{

    public int[] cb;
    public int[] bcb;
    public int[] pb;

    public int cbIndex;
    public int bcbIndex;
    public int pbIndex;

    Wooden_Box(){
        cbIndex = -1;
        bcbIndex = -1;
        pbIndex = -1;
    }

    public void addCorrugated_Box(int I){
        cbIndex++;
        cb[cbIndex] = I;
    }

    public void addBig_Corrugated_Box(int I){
        bcbIndex++;
        bcb[cbIndex] = I;
    }

    public void addPolypropylene_Bag(int I){
        pbIndex++;
        pb[cbIndex] = I;
    }


    Wooden_Box(boolean B){//random
        this.price = GetRandPrice(200, 10000);
        this.weight = GetRandWeight(3, 51);
        this.track = GetRandTrack();
        setStartData(true, false,6);
    }
}
