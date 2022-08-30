import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    static int n;
    static int dp[];
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        arr = new int[n + 1];
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < strs.length; i++) {
            arr[i + 1] = Integer.parseInt(strs[i]);
        }

        dp[1] = arr[1];
        int result = dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
