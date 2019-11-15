package com.company;

public class Corrugated_Box extends Package{


    Corrugated_Box(){
        setStartData(true, true,1);
    }

    Corrugated_Box(boolean B){
        this.price = GetRandPrice(50, 500);
        this.weight = GetRandWeight(1, 10);
        this.track = GetRandTrack();

        setStartData(true, true,1);
    }
}
