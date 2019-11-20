package com.company;


//THIS IS
//Большая коробка из гофрокартона

public class Big_Corrugated_Box extends Package{

    Big_Corrugated_Box(){
    }

    Big_Corrugated_Box(boolean B){
        this.price = GetRandPrice(50, 800);
        this.weight = GetRandWeight(4, 20);
        this.track = GetRandTrack();
    }
}
