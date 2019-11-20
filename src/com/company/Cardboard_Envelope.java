package com.company;

//THIS IS
//Картонный конверт

public class Cardboard_Envelope extends Package {

    Cardboard_Envelope(){
    }

    Cardboard_Envelope(boolean B){
        this.price = GetRandPrice(10, 100);
        this.weight = GetRandWeight(0.05, 0.5);
        this.track = GetRandTrack();
    }
}
