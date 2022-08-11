import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[][] dp = new long[2][N+2];
            int size = 0;
            String[] s = br.readLine().split(" ");
            size = s.length;
            for (int i = 1; i <= size; i++) {
                dp[0][i] = Long.parseLong(s[i-1]);
            }
            s = br.readLine().split(" ");
            size = s.length;
            for (int i = 1; i <= size; i++) {
                dp[1][i] = Long.parseLong(s[i-1]);
            }
            dp[0][2] += dp[1][1];
            dp[1][2] += dp[0][1];

            for (int i = 3; i <= N; i++) {
                dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
            }

            System.out.println(Math.max(dp[0][N],dp[1][N]));

        }

    }
}
