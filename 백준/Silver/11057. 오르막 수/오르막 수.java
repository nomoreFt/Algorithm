import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static int mod = 10007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k >= 0; k--) {
                    dp[i][j] += dp[i - 1][k] % mod;
                }
            }
        }

        int result = 0;
            for (int j = 0; j <= 9; j++) {
                result += dp[N][j] % mod;
            }
        System.out.println(result%mod);
    }
}
