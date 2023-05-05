import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static int n, k;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], dp[i - (j + 2)] * (j + 1));
            }
        }
        System.out.println(dp[n]);

    }
}