import java.util.Scanner;

public class NumberGuess {
    public static void americanFlag(){
        System.out.println("* * * * * * ==================================");
        System.out.println(" * * * * *  ==================================");
        System.out.println("* * * * * * ==================================");
        System.out.println(" * * * * *  ==================================");
        System.out.println("* * * * * * ==================================");
        System.out.println(" * * * * *  ==================================");
        System.out.println("* * * * * * ==================================");
        System.out.println(" * * * * *  ==================================");
        System.out.println("* * * * * * ==================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
    }

    public static void turkishFlag(){
        System.out.println("___________________________________________________");
        System.out.println("|                         ====                    |");
        System.out.println("|                     ===                         |");
        System.out.println("|                   ==                            |");
        System.out.println("|                 ==                              |");
        System.out.println("|               ==                    *           |");
        System.out.println("|              ==                    ***          |");
        System.out.println("|              ==                 *********       |");
        System.out.println("|              ==                   ** **         |");
        System.out.println("|               ==                 *     *        |");
        System.out.println("|                 ===                             |");
        System.out.println("|                    ==                           |");
        System.out.println("|                      ===                        |");
        System.out.println("|                          ====                   |");
        System.out.println("___________________________________________________");


    }
        public static void giveHint(int sayi, int tahmin){
            if(sayi>tahmin){
                if(sayi-tahmin>20){
                    System.out.println("Uzaktasin... Yukari!");
                }else if(sayi-tahmin>10){
                    System.out.println("yakinsin... biraz Yukari!");
                }else if(sayi-tahmin>5){
                    System.out.println("iyisin... azicik Yukari!");
                }else{
                    System.out.println("cok yakinsin... bulursun artik!");
                }
            }else{
                if(tahmin-sayi>20){
                    System.out.println("Uzaktasin... asagi!");
                }else if(tahmin-sayi>10){
                    System.out.println("yakinsin... biraz asagi!");
                }else if(tahmin-sayi>5){
                    System.out.println("iyisin... azicik asagi!");
                }else{
                    System.out.println("cok yakinsin... bulursun artik!");
                }
            }
        }

        public static void printHeader(int language){
            if(language==1){
                americanFlag();
                System.out.println("===================================================================");
                System.out.println("|                                                                  |");
                System.out.println("|  Bu bir Sayi tahmini oyunu, oyundan cikmak icin -1 yazabilirsin. |");
                System.out.println("|                                                                  |");
                System.out.println("===================================================================");
            }else if(language==2){
                turkishFlag();
                System.out.println("===================================================================");
                System.out.println("|                                                                  |");
                System.out.println("|  This is a Number guess game, If you wan to exit, presss -1.     |");
                System.out.println("|                                                                  |");
                System.out.println("===================================================================");
            }
        }
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("New Push1 : Turkce(1) or English(2) ? :");
            int language = input.nextInt();
            printHeader(language);

            String[] randomSeylerNegatif = {" ", "Olmadi", "Cik","Bu da degil", "Maalesef"};
            String[] randomSeylerPozitif = {" ", "Vay anasinin gozu seni!", "Aslanim be!","ooo Kocero!", "Hey yavrum!"};
            int num = 0;
            int sayi = (int)(100*Math.random());
            int tahminTuru = 0;
            while(num!=sayi) {

                int randomSey =randomSeylerNegatif.length ;
                while(randomSey>=randomSeylerNegatif.length){
                    randomSey = (int)(10*Math.random());
                }

                giveHint(sayi,num);
                System.out.print(randomSeylerNegatif[randomSey]  + " Bir sayi soyle: ");
                num = input.nextInt();

                if(num==-1){
                    System.out.print("Pes ettin demekki. Oyle olsun bakalim...");
                    break;
                }

                tahminTuru++;
            }

            int randomSeyPozitif = randomSeylerPozitif.length;
            while(randomSeyPozitif>=randomSeylerPozitif.length){
                randomSeyPozitif = (int)(10*Math.random());
            }

            System.out.println(randomSeylerPozitif[randomSeyPozitif]  + " Kazandin Oyun bitti!");
            System.out.println(tahminTuru  + ". tahminde buldun...");
    }
}
