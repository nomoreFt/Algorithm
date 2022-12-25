import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static int[] D;
    static int[] P;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1];
        P = new int[N + 1];
        String[] strs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(strs[i-1]);
            D[i] = P[i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = i; j >= 0; j--) {
                D[i] = Math.min(D[i], D[i-j] + P[j]);
            }
        }
        System.out.println(D[N]);

    }
}