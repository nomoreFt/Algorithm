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
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        k = Integer.parseInt(strs[1]);

        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp = new long[k + 1];
        Arrays.sort(coins);
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if(j-coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        System.out.println(dp[k]);


    }
}