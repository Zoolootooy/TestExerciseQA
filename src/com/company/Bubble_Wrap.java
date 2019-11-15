package com.company;

public class Bubble_Wrap extends Package {
    Bubble_Wrap(){
        setStartData(false, true,1);
    }

    Bubble_Wrap(boolean B){
        this.price = GetRandPrice(50, 250);
        this.weight = GetRandWeight(0.5, 20);
        this.track = GetRandTrack();

        setStartData(false, true,1);
    }
}
