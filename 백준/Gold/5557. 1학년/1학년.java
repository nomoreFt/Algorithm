import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n -= 1;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int goal = sc.nextInt();

        long[][] dp = new long[n][21];

        dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j - arr[i] >= 0) {
                    dp[i][j] += dp[i-1][j-arr[i]];
                }
                if (j + arr[i] <= 20) {
                    dp[i][j] += dp[i - 1][j + arr[i]];
                }
            }
        }

        System.out.println(dp[n - 1][goal]);

    }
}