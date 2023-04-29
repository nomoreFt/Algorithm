import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
     static int N,K;
     static int[] W;
     static int[] V;
     static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        K = Integer.parseInt(strs[1]);

        W = new int[N+1];
        V = new int[N+1];
        dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            strs = br.readLine().split(" ");
            W[i] = Integer.parseInt(strs[0]);
            V[i] = Integer.parseInt(strs[1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - W[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }




}