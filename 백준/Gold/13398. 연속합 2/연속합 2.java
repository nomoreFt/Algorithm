import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    static int n;
    static int dp[][];
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][2];
        arr = new int[n + 1];
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < strs.length; i++) {
            arr[i + 1] = Integer.parseInt(strs[i]);
        }

        dp[1][0] = arr[1];
        dp[1][1] = arr[1];
        int result = dp[1][1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);//연속해서 더한 값의 최대 값(나 안뽑은거) vs 이전 최대값에서 나 뽑은거
            result = Math.max(result, Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(result);
    }
}
