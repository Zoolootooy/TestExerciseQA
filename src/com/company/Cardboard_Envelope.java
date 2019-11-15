package com.company;

public class Cardboard_Envelope extends Package {

    Cardboard_Envelope(){
        setStartData(false, true,0.25);
    }

    Cardboard_Envelope(boolean B){
        this.price = GetRandPrice(10, 100);
        this.weight = GetRandWeight(0.05, 0.5);
        this.track = GetRandTrack();

        setStartData(false, true,0.25);
    }
}
