package com.company;

import java.io.FileWriter;
import java.io.IOException;


//THIS IS
//Класс-поступления. Тут хранятся все поступившие упаковки, и содержатся методы для:
//-вывода всех упаковок в консоль showAllPackages()
//-формирования из поступивших упаковок готовые к отправке в деревянных ящиках Form()
//-создание лог-файла поступлений createLog_In()
//-возврата места, занимаемого всеми поступлениями ExpectedPlace()
//-возврата предпологаемого минимального кол-ва деревянных ящиков ExpectedWooden_Boxes()
//        (иногда может не совпадать с реальностью ввиду особенностей качественно-количественного набора поступлений)
//-добавление коробки из гофрокартона add_Corrugated_Box()
//-добавление большой коробки из гофрокартона add_Big_Corrugated_Box()
//-добавление картнонного конверта add_Cardboard_Envelope()
//-добавление полипропиленового мешка add_Polypropylene_Bag()
//-добавление пузырчатой упаковки add_Bubble_Wrap()
//-добавление деревянного ящика add_Wooden_Box()
//Принцип распределения основан на последовательном заполнении от больших к маленьким
//Сначала в лог-файл запишется то, что не надо формировать - деревянные ящики
//Затем полипропиленовые мешки, к которым будут добавляться до максимума другие упаковки
//После посылка будет забиваться оставшимися маленькими коробками, а остаток - пузырчатой упаковкой и конвертами
//За этим следует заполнение остатками пузырчатой упаковки и конвертами
//И если вдруг останутся конверты, их определят в самую последнюю очередь

public class Receipts {
    public Corrugated_Box[] cb;
    public Big_Corrugated_Box[] bcb;
    public Cardboard_Envelope[] ce;
    public Polypropylene_Bag[] pb;
    public Bubble_Wrap[] bw;
    public Wooden_Box[] wb;

    public int cbIndex;
    public int bcbIndex;
    public int ceIndex;
    public int pbIndex;
    public int bwIndex;
    public int wbIndex;


    Receipts(){
        cb = new Corrugated_Box[100];
        bcb = new Big_Corrugated_Box[100];
        ce = new Cardboard_Envelope[100];
        pb = new Polypropylene_Bag[100];
        bw = new Bubble_Wrap[100];
        wb = new Wooden_Box[100];

        cbIndex = -1;
        bcbIndex = -1;
        ceIndex = -1;
        pbIndex = -1;
        bwIndex = -1;
        wbIndex = -1;
    }

    //Вывод на консоль всех поступлений
    public void showAllPackages(){
        System.out.println("Corrugated Boxes:");
        for (int i = 0; i <= cbIndex; i++){
            System.out.println(i + ":\nprice:\t" + cb[i].price + "\nweight:\t" + cb[i].weight + "\ntrack:\t" + cb[i].track);
            System.out.println("____________________\n");
        }

        System.out.println("Big Corrugated Boxes:");
        for (int i = 0; i <= bcbIndex; i++){
            System.out.println(i + ":\nprice:\t" + bcb[i].price + "\nweight:\t" + bcb[i].weight + "\ntrack:\t" + bcb[i].track);
            System.out.println("____________________\n");
        }

        System.out.println("Cardboard Envelope:");
        for (int i = 0; i <= ceIndex; i++){
            System.out.println(i + ":\nprice:\t" + ce[i].price + "\nweight:\t" + ce[i].weight + "\ntrack:\t" + ce[i].track);
            System.out.println("____________________\n");
        }

        System.out.println("Polypropylene Bags:");
        for (int i = 0; i <= pbIndex; i++){
            System.out.println(i + ":\nprice:\t" + pb[i].price + "\nweight:\t" + pb[i].weight + "\ntrack:\t" + pb[i].track);
            System.out.println("____________________\n");
        }

        System.out.println("Bubble Wraps:");
        for (int i = 0; i <= bwIndex; i++){
            System.out.println(i + ":\nprice:\t" + bw[i].price + "\nweight:\t" + bw[i].weight + "\ntrack:\t" + bw[i].track);
            System.out.println("____________________\n");
        }

        System.out.println("Wooden Boxes:");
        for (int i = 0; i <= wbIndex; i++){
            System.out.println(i + ":\nprice:\t" + wb[i].price + "\nweight:\t" + wb[i].weight + "\ntrack:\t" + wb[i].track);
            System.out.println("____________________\n");
        }
    }

    public void Form(){
        String path = "D://Log-out.txt";
        try(FileWriter writer = new FileWriter("D://Log-out.txt", false)){//append = дозаписать
            String S = "";
            int counter = 0;
            double price = 0, weight = 0;


            for (int i = 0; i <= cbIndex; i++){
                counter++;
                price += cb[cbIndex].price;
                weight += cb[cbIndex].weight;
            }
            for (int i = 0; i <= bcbIndex; i++){
                counter++;
                price += bcb[bcbIndex].price;
                weight += bcb[bcbIndex].weight;
            }
            for (int i = 0; i <= ceIndex; i++){
                counter++;
                price += ce[ceIndex].price;
                weight += ce[ceIndex].weight;
            }
            for (int i = 0; i <= pbIndex; i++){
                counter++;
                price += pb[pbIndex].price;
                weight += pb[pbIndex].weight;
            }
            for (int i = 0; i <= bwIndex; i++){
                counter++;
                price += bw[bwIndex].price;
                weight += bw[bwIndex].weight;
            }
            for (int i = 0; i <= wbIndex; i++){
                counter++;
                price += wb[wbIndex].price;
                weight += wb[wbIndex].weight;
            }

            price = Math.round(price * 100.0) / 100.0;
            weight = Math.round(weight * 100.0) / 100.0;

            S += "На склад поступило " + counter + " посылок:\r\n";
            S += "- коробки из гофрокартона: " + (cbIndex+1) + "шт.\r\n";
            S += "- большие коробки из гофрокартона: " + (bcbIndex+1) + "шт.\r\n";
            S += "- картонные конверты: " + (ceIndex+1) + "шт.\r\n";
            S += "- мешки полипропиленовые: " + (pbIndex+1) + "шт.\r\n";
            S += "- посылки в воздушно-пузырчатой пленке: " + (bwIndex+1) + "шт.\r\n";
            S += "- деревянные ящики: " + (wbIndex+1) + "шт.\r\n";

            writer.write(S);
            writer.append("");
            writer.flush();
            S = "";

            S += "Общая оцененная стоимость поступивших посылок: " + price + " грн\r\n";
            S += "Общий вес поступивших посылок: " + weight + " кг.\r\n";
            S += "Подготовленные посылки на отправку из склада:\r\n\r\n";
            writer.write(S);
            writer.append("");
            writer.flush();
            S = "";

            if (wbIndex > -1){
                for (int i = 0; i <= wbIndex; i++){
                    Packing P = new Packing();
                    P.add_wb(wb[i]);
                    P.toLog_File(path);
                }
            }

            if (pbIndex > -1){
                while (pbIndex > -1){
                    Packing P = new Packing();
                    P.add_pb(pb[pbIndex]);
                    pbIndex--;

                    // +1 bcb
                    if ((bcbIndex > -1) && (P.Place < 6)){
                        P.add_bcb(bcb[bcbIndex]);
                        bcbIndex--;
                    }

                    //+2cb
                    if ((cbIndex > 0) && (P.Place < 6)){
                        P.add_cb(cb[cbIndex]);
                        P.add_cb(cb[cbIndex-1]);
                        cbIndex -= 2;
                    }

                    //+2bw
                    if ((bwIndex > 0) && (P.Place < 6)){
                        P.add_bw(bw[bwIndex]);
                        P.add_bw(bw[bwIndex-1]);
                        bwIndex -= 2;
                    }

                    //+1cb +1 bw
                    if ((bwIndex == 0) && (cbIndex == 0) && (P.Place < 6)){
                        P.add_bw(bw[bwIndex]);
                        P.add_cb(cb[cbIndex]);
                        cbIndex--;
                        bwIndex --;
                    }

                    //+1cb and ce
                    if ((cbIndex == 0) && (ceIndex > -1) && (P.Place < 6)){
                        P.add_cb(cb[cbIndex]);
                        while ((P.Place < 6) &&((ceIndex > -1))){
                            P.add_ce(ce[ceIndex]);
                            ceIndex--;
                        }
                        cbIndex--;
                    }

                    //+1bw and ce
                    if ((bwIndex == 0) && (ceIndex > -1)  && (P.Place < 6)){
                        P.add_bw(bw[bwIndex]);
                        while (P.Place < 6){
                            P.add_ce(ce[ceIndex]);
                            ceIndex--;
                        }
                        bwIndex--;
                    }

                    //+1cb
                    if ((cbIndex == 0) && (P.Place < 6)){
                        P.add_cb(cb[cbIndex]);
                        cbIndex--;
                    }

                    //+1bw
                    if ((bwIndex == 0)  && (P.Place < 6)){
                        P.add_bw(bw[bwIndex]);
                        bwIndex--;
                    }

                    //+ce
                    if ((ceIndex > -1)  && (P.Place < 6)){
                        while ((P.Place < 6) && (ceIndex > -1)){
                            P.add_ce(ce[ceIndex]);
                            ceIndex--;
                        }
                    }

                    P.toLog_File(path);
                }
            }

            if (bcbIndex > -1){
                while (bcbIndex > -1){
                    Packing P = new Packing();

                    // +3 bcb
                    if ((bcbIndex > 1) && (P.Place < 6)){
                        P.add_bcb(bcb[bcbIndex]);
                        P.add_bcb(bcb[bcbIndex-1]);
                        P.add_bcb(bcb[bcbIndex-2]);
                        bcbIndex -= 3;
                    }

                    //+2bcb
                    if ((bcbIndex == 1) && (P.Place < 6)){
                        P.add_bcb(bcb[bcbIndex]);
                        P.add_bcb(bcb[bcbIndex-1]);
                        bcbIndex -= 2;
                    }

                    //+1bcb
                    if ((bcbIndex == 0) && (P.Place < 6)){
                        P.add_bcb(bcb[bcbIndex]);
                        bcbIndex--;
                    }

                    if (P.Place < 6){
                        while (P.Place < 6){

                            //заполнить cb
                            if ((cbIndex > -1) && (P.Place < 6)){
                                P.add_cb(cb[cbIndex]);
                                cbIndex--;
                            }

                            //заполнить bw
                            if ((bwIndex > -1) && (P.Place < 6) && (cbIndex < 0)){
                                P.add_bw(bw[bwIndex]);
                                bwIndex--;
                            }

                            //заполнить ce
                            if ((ceIndex > -1) && (P.Place < 6) && (bwIndex < 0) && (cbIndex < 0)){
                                P.add_ce(ce[ceIndex]);
                                ceIndex--;
                            }
                        }
                    }


                    P.toLog_File(path);
                }
            }

            if (cbIndex > -1){
                while (cbIndex > -1){
                    Packing P = new Packing();
                    while ((P.Place < 6) && ((cbIndex > -1) || (bwIndex > -1) || (ceIndex > -1))) {
                        //заполнить cb
                        if ((cbIndex > -1) && (P.Place < 6)){
                            P.add_cb(cb[cbIndex]);
                            cbIndex--;
                        }

                        //заполнить bw
                        if ((bwIndex > -1) && (P.Place < 6) && (cbIndex < 0)){
                            P.add_bw(bw[bwIndex]);
                            bwIndex--;
                        }

                        //заполнить ce
                        if ((ceIndex > -1) && (P.Place < 6) && (bwIndex < 0) && (cbIndex < 0)){
                            P.add_ce(ce[ceIndex]);
                            ceIndex--;
                        }
                    }


                    P.toLog_File(path);
                }
            }


            if (bwIndex > -1){
                while (bwIndex > -1){
                    Packing P = new Packing();
                    while ((P.Place < 6) && ((bwIndex > -1) || (ceIndex > -1))){
                        //заполнить bw
                        if ((bwIndex > -1) && (P.Place < 6)){
                            P.add_bw(bw[bwIndex]);
                            bwIndex--;
                        }

                        //заполнить ce
                        if ((ceIndex > -1) && (P.Place < 6) && (bwIndex < 0)){
                            P.add_ce(ce[ceIndex]);
                            ceIndex--;
                        }
                    }

                    P.toLog_File(path);
                }
            }

            if (ceIndex > -1){
                while (ceIndex > -1){
                    Packing P = new Packing();

                    while ((P.Place < 6) && (ceIndex > -1)){
                        if ((ceIndex > -1) && (P.Place < 6)){
                            P.add_ce(ce[ceIndex]);
                            ceIndex--;
                        }
                    }

                    P.toLog_File(path);
                }
            }


        } catch(IOException ex){
            System.out.println(ex.getMessage());
        };
    }


    public void createLog_In(){
        try(FileWriter writer = new FileWriter("D://Log-in.txt", false)){//append = дозаписать
            String S = "";

            if (cbIndex > -1){
                for (int i = 0; i <= cbIndex; i++){
                    S += "коробка из гофрокартона\t\t\t\t" + cb[i].track;
                    S += "\t\t" + "(" + cb[i].weight + "кг, ";
                    S += cb[i].price + " грн)";
                    writer.write(S);
                    writer.append("\r\n");
                    writer.flush();
                    S = "";
                }
            }

            if (bcbIndex > -1){
                for (int i = 0; i <= bcbIndex; i++){
                    S += "большая коробка из гофрокартона\t\t\t" + bcb[i].track;
                    S += "\t\t" + "(" + bcb[i].weight + "кг, ";
                    S += bcb[i].price + " грн)";
                    writer.write(S);
                    writer.append("\r\n");
                    writer.flush();
                    S = "";
                }
            }

            if (ceIndex > -1){
                for (int i = 0; i <= ceIndex; i++){
                    S += "картонный конверт\t\t\t\t" + ce[i].track;
                    S += "\t\t" + "(" + ce[i].weight + "кг, ";
                    S += ce[i].price + " грн)";
                    writer.write(S);
                    writer.append("\r\n");
                    writer.flush();
                    S = "";
                }
            }

            if (pbIndex > -1){
                for (int i = 0; i <= pbIndex; i++){
                    S += "мешок полипропиленовый\t\t\t\t" + pb[i].track;
                    S += "\t\t" + "(" + pb[i].weight + "кг, ";
                    S += pb[i].price + " грн)";
                    writer.write(S);
                    writer.append("\r\n");
                    writer.flush();
                    S = "";
                }
            }

            if (bwIndex > -1){
                for (int i = 0; i <= bwIndex; i++){
                    S += "посылка в воздушно-пузырчатой пленке\t\t" + bw[i].track;
                    S += "\t\t" + "(" + bw[i].weight + "кг, ";
                    S += bw[i].price + " грн)";
                    writer.write(S);
                    writer.append("\r\n");
                    writer.flush();
                    S = "";
                }
            }


            //запись уже имеющихся деревянных ящиков
            if (wbIndex > -1){
                for (int i = 0; i <= wbIndex; i++){
                    S += "деревянный ящик\t\t\t\t\t" + wb[i].track;
                    S += "\t\t" + "(" + wb[i].weight + "кг, ";
                    S += wb[i].price + " грн)";
                    writer.write(S);
                    writer.append("\r\n");
                    writer.flush();
                    S = "";
                }
            }
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        };
    }



    //возвращает место, занимаемое всеми упаковками
    public double ExpectedPlace(){
        double Result = 0;
        Result += (cbIndex+1)*1;
        Result += (bcbIndex+1)*2;
        Result += (ceIndex+1)*0.25;
        Result += (pbIndex+1)*4;
        Result += (bwIndex+1)*1;
        Result += (wbIndex+1)*6;
        return  Result;
    }

    public int ExpectedWooden_Boxes(){
        int Result = 0;

        while (Result*6 < this.ExpectedPlace()){
            Result++;
        };

        return Result;
    }


    //добавить коробку из гофрокартона
    public void add_Corrugated_Box(){
        cbIndex++;
        cb[cbIndex] = new Corrugated_Box(true);
    }

    //добавить большую коробку из гофрокартона
    public void add_Big_Corrugated_Box (){
        bcbIndex++;
        bcb[bcbIndex] = new Big_Corrugated_Box(true);
    }

    //добавить картонный конверт
    public void add_Cardboard_Envelope(){
        ceIndex++;
        ce[ceIndex] = new Cardboard_Envelope(true);
    }

    //добавить полипропиленовый мешок
    public void add_Polypropylene_Bag(){
        pbIndex++;
        pb[pbIndex] = new Polypropylene_Bag(true);
    }

    //добавить посылку в воздушно-пупырчатой плёнке
    public void add_Bubble_Wrap(){
        bwIndex++;
        bw[bwIndex] = new Bubble_Wrap(true);
    }

    //добавить деревянный ящик
    public void add_Wooden_Box(){
        wbIndex++;
        wb[wbIndex] = new Wooden_Box(true);
    }
}
