import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

class Main {
    static int[] dp;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        if (n == 1) {

            System.out.println(1);
            return;
        }
        if (n == 2) {

            System.out.println(2);
            return;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);

    }
}

