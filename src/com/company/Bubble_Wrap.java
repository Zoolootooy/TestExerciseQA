package com.company;


//THIS IS
//Пузырчатая упаковка
public class Bubble_Wrap extends Package {
    Bubble_Wrap(){
    }

    Bubble_Wrap(boolean B){
        this.price = GetRandPrice(50, 250);
        this.weight = GetRandWeight(0.5, 20);
        this.track = GetRandTrack();
    }
}
