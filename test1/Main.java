import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a = 4;

        System.out.println((a >> 1)+(a << 2) );

        int x = 0, y = -2;
        System.out.println(Math.min(x,y));


        a = 5;
        int b = 9;
        int c = 0;
        if (a > b) {
            c = a;
            a = b;
            b = c;
        }
        System.out.println(b + "," + a);
    }
}
