import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] dp;
    static int n;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        dp = new int[1002];
        p = new int[1002];
        int length = strs.length;
        for (int i = 1; i <= length; i++) {
            p[i] = Integer.parseInt(strs[i-1]);
            dp[i] = Integer.parseInt(strs[i-1]);
        }
        dp[0] = 0;
        dp[1] = p[1];

        for (int i = 2; i <= n; i++) {
            for (int k = 1; k < i; k++) { //i == 4 , k = 1, 2, 3
                dp[i] = Math.min(dp[i],dp[i - k] + dp[k]);
            }
        }
        System.out.println(dp[n]);
    }
}

