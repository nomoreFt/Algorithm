import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int cnt = 0;
        cnt = str.charAt(0) == 'd'? 10 : 26;

        for (int i = 1; i < str.length(); i++) {
            char prev = str.charAt(i - 1);
            char now = str.charAt(i);

            if (prev == now) {
                if(now == 'd') cnt *= 9;
                else cnt *= 25;
            }else{
                if(now == 'd') cnt *= 10;
                else cnt *= 26;
            }
        }

        System.out.println(cnt);

    }
}
