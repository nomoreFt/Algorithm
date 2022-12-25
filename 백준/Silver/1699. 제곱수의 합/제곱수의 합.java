import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        D = new int[N + 1];
        Arrays.fill(D, 100001);
        D[0] = 0;
        D[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j * j <= i; j++) {
                D[i] = Math.min(D[i],D[i-j*j] + 1);
            }
        }
        System.out.println(D[N]);
    }
}
