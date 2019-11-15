package com.company;

public class Wooden_Box extends Package{

    Wooden_Box(){
        setStartData(true, false,6);
    }

    Wooden_Box(boolean B){//random
        this.price = GetRandPrice(200, 10000);
        this.weight = GetRandWeight(3, 51);
        this.track = GetRandTrack();
        setStartData(true, false,6);
    }
}
