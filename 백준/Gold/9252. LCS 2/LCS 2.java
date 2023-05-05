import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int[][] visited = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    visited[i][j] = 1;
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                        visited[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i][j-1];
                        visited[i][j] = 3;
                    }
                }
            }
        }

        System.out.println(dp[n][m]);
        StringBuilder sb = new StringBuilder();

        while (n > 0 && m > 0) {
            if (visited[n][m] == 1) {
                sb.append(str1.charAt(n - 1));
                n--;m--;
            } else if (visited[n][m] == 2) {
                n--;
            } else {
                m--;
            }
        }
        System.out.println(sb.reverse().toString());


    }
}