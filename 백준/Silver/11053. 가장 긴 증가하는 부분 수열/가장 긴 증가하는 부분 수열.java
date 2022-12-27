import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        String[] strs = br.readLine().split(" ");
        int len = strs.length;
        for (int i = 1; i <= len; i++) {
            arr[i] =Integer.parseInt(strs[i-1]);
            dp[i] = 1;
        }
        int result = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            result = Math.max(result,dp[i]);
        }
        System.out.println(result);
    }
}
