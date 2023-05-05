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
        n = Integer.valueOf(strs[0]);
        k = Integer.valueOf(strs[1]);

        coins = new int[n];
        dp = new long[k + 1];

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(coins);
        Arrays.fill(dp, -1);

        dp[0] = 0;


        for (int i = 0; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                if (j - coins[i] >= 0){
                    if(dp[j - coins[i]] != -1) {
                        if(dp[j] == -1) {
                            dp[j] = dp[j - coins[i]] + 1;
                        } else {
                            dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                        }    
                    }
                    
                }
            }
        }

        System.out.println(dp[k]);
    }
}