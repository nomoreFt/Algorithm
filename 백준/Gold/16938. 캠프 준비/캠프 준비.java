import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int ans = 0;
    static int N,L,R,X;
    static int A[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        X = sc.nextInt();

        A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int ans = 0;



        for (int bit = 0; bit < (1 << N); bit++) {
            int total = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) != 0) {
                    total += A[i];
                    max = Math.max(max, A[i]);
                    min = Math.min(min, A[i]);
                    cnt++;
                    //System.out.print(i + " ,");
                }
            }
            //System.out.print("===");

            if(cnt >= 2 && total >= L && total <= R && (max-min) >= X){
                ans++;
              //  System.out.print("select");
            }
            //System.out.println();
        }

        System.out.println(ans);

    }
}

