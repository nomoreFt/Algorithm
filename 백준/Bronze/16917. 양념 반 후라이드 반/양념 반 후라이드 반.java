import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int cost = 0;
        if ((A + B) > (C * 2)) {
            //반반으로 채움
            int min = Math.min(X, Y);
            X -= min;
            Y -= min;
            cost += (min * 2) * C;
            cost += Math.min(X*A,(X*2)*C);
            cost += Math.min(Y*B,(Y*2)*C);

        }else{
            //그냥 각각 삼
            cost = (X * A) + (B * Y);
        }
        System.out.println(cost);
    }
}
