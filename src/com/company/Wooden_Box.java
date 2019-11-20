package com.company;


//THIS IS
//Деревянный ящик

public class Wooden_Box extends Package{


    Wooden_Box(){
    }


    Wooden_Box(boolean B){//random
        this.price = GetRandPrice(200, 10000);
        this.weight = GetRandWeight(3, 51);
        this.track = GetRandTrack();
    }
}
