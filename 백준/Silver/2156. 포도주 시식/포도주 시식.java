import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] grapes = new int[n+1];

        for (int i = 1; i <= n; i++) {
            grapes[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = grapes[1];
        if(n > 1) dp[2] = grapes[1] + grapes[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grapes[i], dp[i - 3] + grapes[i - 1] + grapes[i]));

        }
        
            System.out.println(dp[n]);


    }
}