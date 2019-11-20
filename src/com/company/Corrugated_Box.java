package com.company;


//THIS IS
//Коробка из гофрокартона

public class Corrugated_Box extends Package{


    Corrugated_Box(){
    }

    Corrugated_Box(boolean B){
        this.price = GetRandPrice(50, 500);
        this.weight = GetRandWeight(1, 10);
        this.track = GetRandTrack();
    }
}
