package com.company;

import java.io.FileWriter;
import java.io.IOException;

//THIS IS
//вспомогающий класс-коробка, который будет следить за корректностью распределения
//Тут также хранятся методы для:
//-создания лог-файла, в который запишутся уже распределённые посылки toLog_File(String path)
//-добавления в коробку деревянного ящика add_wb(Wooden_Box _wb)
//-добавления в коробку полипропиленового мешка add_pb(Polypropylene_Bag _pb)
//-добавления в коробку большой коробки из гофрокартона add_bcb(Big_Corrugated_Box _bcb)
//-добавления в коробку коробки из гофрокартона add_cb(Corrugated_Box _cb)
//-добавления в коробку пузырчатой паковки add_bw(Bubble_Wrap _bw)
//-добавления в коробку картонного конверта add_ce(Cardboard_Envelope _ce)
//Каждый метод добавления перед таковым проверяет, есть ли необходимое свободное место для каждого типа упаковки.
//Метод создания лог-файла визуально разбит на несколько блоков шапкой из комментария с названием,
//обрамлённым нижним подчёркиванием. Он выдаст запись в лог-файл универсально для любого качественно-количественного
//состава текущей коробки. Величины суммарной цены и веса округлены до сотых ввиду некорректного вывода при некоторых случаях.
//Для удобства чтения лог-файла предусмотрены варианты разделительных запятых, пробелов, открывающихся и закрывающихся
//квадратных скобок, а так же объединение в одну коробку из гофрокартона до 4 конвертов.



public class Packing extends Receipts{
    public double Place; //занятое место

    Packing (){
        Place = 0;

        cbIndex = -1;
        bcbIndex = -1;
        ceIndex = -1;
        pbIndex = -1;
        bwIndex = -1;
        wbIndex = -1;
    }

    public void toLog_File(String path){
        String S = "";
        S += "- деревянный ящик (";
//______Блок добавления веса____________________________________
        double W = 0;
        if (wbIndex > -1){
            W += wb[wbIndex].weight;
        }

        if (pbIndex > -1){
            W += pb[pbIndex].weight;
        }

        if (bcbIndex > -1){
            for (int i = 0; i <= bcbIndex; i++){
                W += bcb[i].weight;
            }
        }

        if (cbIndex > -1){
            for (int i = 0; i <= cbIndex; i++){
                W += cb[i].weight;
            }
        }

        if (bwIndex > -1){
            for (int i = 0; i <= bwIndex; i++){
                W += bw[i].weight;
            }
        }

        if (ceIndex > -1){
            for (int i = 0; i <= ceIndex; i++){
                W += ce[i].weight;
            }
        }
        W = Math.round(W * 100.0) / 100.0;

        S += W + " кг, ";

//______Блок добавления цены____________________________________
        double P = 0;
        if (wbIndex > -1){
            P += wb[wbIndex].price;
        }

        if (pbIndex > -1){
            P += pb[pbIndex].price;
        }

        if (bcbIndex > -1){
            for (int i = 0; i <= bcbIndex; i++){
                P += bcb[i].price;
            }
        }

        if (cbIndex > -1){
            for (int i = 0; i <= cbIndex; i++){
                P += cb[i].price;
            }
        }

        if (bwIndex > -1){
            for (int i = 0; i <= bwIndex; i++){
                P += bw[i].price;
            }
        }

        if (ceIndex > -1){
            for (int i = 0; i <= ceIndex; i++){
                P += ce[i].price;
            }
        }
        P = Math.round(P * 100.0) / 100.0;

        S += P + " грн) [";

//______Блок добавления трека____________________________________
        if (wbIndex > -1){
            S += wb[wbIndex].track;
            wbIndex--;
        }

        if (pbIndex > -1){
            S += pb[pbIndex].track;
            Place -= 4;
            if (this.Place > 0){//что-то осталось
                S += ", ";
            }
            pbIndex--;
        }

        if (bcbIndex > -1){
            while (bcbIndex > -1) {
                S += bcb[bcbIndex].track;
                Place -= 2;
                if (this.Place > 0){//что-то осталось
                    S += ", ";
                }
                bcbIndex--;
            }
        }

        if (cbIndex > -1){
            while (cbIndex > -1) {
                S += cb[cbIndex].track;
                Place--;
                if (this.Place > 0){//что-то осталось
                    S += ", ";
                }
                cbIndex--;
            }
        }

        if (bwIndex > -1){
            while (bwIndex > -1){
                S += bw[bwIndex].track;
                Place--;
                if (this.Place > 0){//что-то осталось
                    S += ", ";
                }
                bwIndex--;
            }
        }

        int c = 0;

        if (ceIndex > -1){
            while (ceIndex > -1){
                if(c >= 4){
                    S += "]";
                    if (ceIndex > -1){
                        S += ", ";
                    }
                    c = 0;
                }
                if (c == 0){
                    S += " коробка из гофрокартона[";
                }
                S += ce[ceIndex].track;
                Place -= 0.25;
                if ((this.Place > 0) && (c != 3)){//что-то осталось
                    S += ", ";
                }
                if (ceIndex < 0){
                    S += "]";
                }
                if (Place == 0){
                    S += "]";
                }
                ceIndex--;
                c++;
            }
        }




        S += "]";

//______Блок дозаписи в файл____________________________________
        try(FileWriter writer = new FileWriter(path, true)){//append = дозаписать
            writer.write(S);
            writer.append("\r\n");
            writer.flush();
            S = "";
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        };


    }

    public void add_wb(Wooden_Box _wb){
        if (Place == 0) {//если свободно 6 места
            wbIndex++;
            wb[wbIndex] = _wb;
            Place += 6;
        }
    }

    public void add_pb(Polypropylene_Bag _pb){
        if (Place <= 2){//если свободно >=4 места
            pbIndex++;
            pb[pbIndex] = _pb;
            Place += 4;
        }
    }

    public void add_bcb(Big_Corrugated_Box _bcb){
        if (Place <= 4){
            bcbIndex++;
            bcb[bcbIndex] = _bcb;
            Place += 2;
        }
    }

    public void add_cb(Corrugated_Box _cb){
        if (Place <= 5){
            cbIndex++;
            cb[cbIndex] = _cb;
            Place++;
        }
    }

    public void add_bw(Bubble_Wrap _bw){
        if (Place <= 5){
            bwIndex++;
            bw[bwIndex] = _bw;
            Place++;
        }
    }

    public void add_ce(Cardboard_Envelope _ce){
        if (Place <= 5.75){
            ceIndex++;
            ce[ceIndex] = _ce;
            Place += 0.25;
        }
    }

}
