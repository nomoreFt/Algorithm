import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[100002][4];
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            for (int k = 1; k <= 3; k++) {
                if (k == 1) {
                    dp[i][k] = dp[i - 1][2] + dp[i - 1][3];
                } else if (k == 2) {
                    dp[i][k] = dp[i - 2][3] + dp[i - 2][1];
                }else {
                    dp[i][k] = dp[i - 3][2] + dp[i - 3][1];
                }
                dp[i][k] %= 1000000009;
            }
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i = 1; i <= 3; i++) {
            answer += dp[n][i];
            answer %= 1000000009;
            }
            System.out.println(answer);
        }
    }
}

