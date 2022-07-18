import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static long[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new long[1000003];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= 1000000; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%1000000009;
            }
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]%1000000009);
        }
    }
}

