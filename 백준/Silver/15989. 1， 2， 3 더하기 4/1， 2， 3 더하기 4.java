import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static int n, k;
    static int[] coins;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        dp = new long[10001];
        dp[0] = 1;

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 10000; j++) {
                if (j - i >= 0) {
                    dp[j] += dp[j - i];
                }
            }
        }


        while (t-- > 0) {
            int n = Integer.valueOf(br.readLine());

            System.out.println(dp[n]);


        }
    }
}