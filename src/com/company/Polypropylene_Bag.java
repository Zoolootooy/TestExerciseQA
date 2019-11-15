package com.company;

public class Polypropylene_Bag extends Package {
    Polypropylene_Bag(){
        setStartData(false, true,4);
    }

    Polypropylene_Bag(boolean B){
        this.price = GetRandPrice(100, 600);
        this.weight = GetRandWeight(5, 35);
        this.track = GetRandTrack();

        setStartData(false, true,4);
    }
}
