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
    public static String giveHint(int sayi, int tahmin,int language){
        String result="";
        String[][] textUp = {
                {"","Uzaktasin... Yukari!","Not close, Guess higher!"},
                {"","Yakinsin... Biraz yukari!","You're Close, Guess higher!"},
                {"","Yakinsin... Azicik yukari!","So Close, a bit higher!"},
                {"","Cok yakinsin.. bulursun artik!","Almost there, you can find it!"},};

        String[][] textDown = {
                {"","Uzaktasin... asagi!","Not close, Guess lower!"},
                {"","yakinsin... biraz asagi!","You're Close, Guess lower!"},
                {"","iyisin... azicik asagi!","So Close, a bit lower!"},
                {"","Cok yakinsin.. bulursun artik!","Almost there, you can find it!"},};

        if(tahmin>0) {
            if (sayi > tahmin) {
                if (sayi - tahmin > 20) {
                    result=textUp[0][language];
                } else if (sayi - tahmin > 10) {
                    result=textUp[1][language];
                } else if (sayi - tahmin > 5) {
                    result=textUp[2][language];
                } else {
                    result=textUp[3][language];
                }
            } else {
                if (tahmin - sayi > 20) {
                    result=textDown[0][language];
                } else if (tahmin - sayi > 10) {
                    result=textDown[1][language];
                } else if (tahmin - sayi > 5) {
                    result=textDown[2][language];
                } else {
                   result=textDown[3][language];
                }
            }
        }

        return result;
    }
    public static void printHeader(int language){
        if(language==1){
            turkishFlag();
            System.out.println("===================================================================");
            System.out.println("|                                                                  |");
            System.out.println("|  Bu bir Sayi tahmini oyunu, oyundan cikmak icin -1 yazabilirsin. |");
            System.out.println("|                                                                  |");
            System.out.println("===================================================================");
        }else if(language==2){
            americanFlag();
            System.out.println("===================================================================");
            System.out.println("|                                                                  |");
            System.out.println("|  This is a Number guess game, If you wan to exit, presss -1.     |");
            System.out.println("|                                                                  |");
            System.out.println("===================================================================");
        }
    }
    public static String starterHint(int num,int language){
        String result ="";
        String[][] hints ={
                {"","Baslangic yakinsamasi: Bir elin parmaklari?","Starter hint: Fingers of hand"},
                {"","Baslangic yakinsamasi: 2. Dunya savasi?","Starter hint: World war 2"},
                {"","Baslangic yakinsamasi: Kac spartali?","Starter hint: How many Spartans?"},
        };
        if(num<11){
            result=hints[0][language];
        }else if(num<51){
            result=hints[1][language];
        }else{
            result=hints[2][language];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("New Push1 : Turkce(1) or English(2) ? :");
        int language = input.nextInt();
        printHeader(language);

        String[][] randomStuffNegative = {{"", "", ""},
                {"", "Olmadi", "No"},
                {"", "Cik", "Didn't Work"},
                {"", "Bu da degil", "it's not"},
                {"", "Maalesef", "unfortunately"}
        };

        String[][] askNumber = {{"", "Bir sayi Soyle:", "Guess the Number:"}};

        String[][] randomStuffPositive = {
                {"", "Vay anasinin gozu seni!", "Dude!"},
                {"", "Aslanim be! Kazandin!", "You're the Man! You won!"},
                {"", "ooo Kocero! Kazandin!", "Buddy! You won!"},
                {"", "Hey yavrum! Kazandin!", "My boy! You won!"}
        };

        String[][] GameOver = {
                {"", " Kazandin! Oyun bitti.", " You won! Game over."},
                {"", "Vazgectin... Oyun bitti", "Cancelled... Game over..."},
        };

        String[][] GuessCount = {
                {"", "Tahminde bulundun.", "Total Guess"},
        };

        int playAgain = 1;

        while (playAgain == 1)
        {
            int guessedNum = -1;
            int number = (int) (100 * Math.random());
            int guessCount = 0;

            while (guessedNum != number)
            {
                int randomNum = randomStuffNegative.length;
                while (randomNum >= randomStuffNegative.length) {
                    randomNum = (int) (10 * Math.random());
                }


                if (guessedNum > 0) {
                    System.out.print(randomStuffNegative[randomNum][language] + ", "+ giveHint(number, guessedNum, language) +", " + askNumber[0][language]);
                } else {

                    System.out.print(starterHint(number,language) +" , "+askNumber[0][language]);
                }
                guessedNum = input.nextInt();

                if (guessedNum == -1) {
                    System.out.print(GameOver[1][language]);
                    break;
                }

                guessCount++;
            }

            int randomSeyPozitif = randomStuffPositive.length;
            while (randomSeyPozitif >= randomStuffPositive.length) {
                randomSeyPozitif = (int) (10 * Math.random());
            }

            System.out.println(randomStuffPositive[randomSeyPozitif][language]);
            System.out.println(guessCount + " " + GuessCount[0][language]);

            String[][] playAgainText ={
                    {"","Tekrar oynar misin? Evet(1) Hayir(herhangi bir sayi): ","Play again? Yes(1) No(Any number): "},
            };
            System.out.print(playAgainText[0][language]);
            playAgain=input.nextInt();

        }
    }
}
