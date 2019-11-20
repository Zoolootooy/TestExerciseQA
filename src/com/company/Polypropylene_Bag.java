package com.company;

//THIS IS
//полипропиленовый мешок


public class Polypropylene_Bag extends Package {
    Polypropylene_Bag(){
    }

    Polypropylene_Bag(boolean B){
        this.price = GetRandPrice(100, 600);
        this.weight = GetRandWeight(5, 35);
        this.track = GetRandTrack();
    }
}
