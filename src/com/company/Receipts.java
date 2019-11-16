package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Receipts {
    public Corrugated_Box[] cb;
    private Big_Corrugated_Box[] bcb;
    private Cardboard_Envelope[] ce;
    private Polypropylene_Bag[] pb;
    private Bubble_Wrap[] bw;
    private Wooden_Box[] wb;

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
        try(FileWriter writer = new FileWriter("D://Test_log-out.txt", false)){//append = дозаписать
            String S = "";

            //запись уже имеющихся деревянных ящиков
            if (wbIndex > -1){
                for (int i = 0; i <= wbIndex; i++){
                    S += "- деревянный ящик (" + wb[i].weight + "кг, ";
                    S += wb[i].price + " грн)";
                    S += " [" + wb[i].track + "]";
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

    public void createLog_In(){
        try(FileWriter writer = new FileWriter("D://Test_log-in.txt", false)){//append = дозаписать
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
