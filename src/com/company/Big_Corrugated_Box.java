package com.company;

public class Big_Corrugated_Box extends Package{

    Big_Corrugated_Box(){
        setStartData(true, true,2);
    }

    Big_Corrugated_Box(boolean B){
        this.price = GetRandPrice(50, 800);
        this.weight = GetRandWeight(4, 20);
        this.track = GetRandTrack();

        setStartData(true, true,1);
    }
}
