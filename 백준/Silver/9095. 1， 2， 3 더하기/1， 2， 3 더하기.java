import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

class Main {
    static int[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[13];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= 11; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}

