import java.util.Scanner;


public class NumaraTahmin {
    public static int karesi(int sayi){
        int deger = sayi *sayi;
        return deger;
    }

    public static String ciftmitekmi(int sayi){
        int result=sayi%2;

        if(result==0){
            return "Bu sayi Cift";
        }else{
            return "Bu sayi tek";
        }

    }

    public static String[] asalMi(int sayi){
        String[] result = new String[2];
        int counter = 0;

        for(int i=2;i<sayi;i++){
            counter++;
            result[0]="Bolen: "+i;
            result[1]="Adim: "+counter;

            if(sayi%i==0){
                return result;
            }
        }

        result[0]="Bolen: "+sayi;
        return result;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir Sayi gir?: ");
        int sayi = input.nextInt();

       String[] ret = asalMi(sayi);

        System.out.println(ret[0] + "," + ret[1]);

        System.out.println("Bu sayiyi girdin: " + sayi);

    }
}
