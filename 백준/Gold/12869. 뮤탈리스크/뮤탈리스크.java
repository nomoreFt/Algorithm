import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    static int N;
    static int dp[][][] = new int[61][61][61];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");

        for(int i = 0; i < 61; i++){
            for(int j = 0; j < 61; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int[] arr = new int[3];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }

        System.out.println(solve(arr[0], arr[1], arr[2]));

    }

    private static int solve(int scv1, int scv2, int scv3) {
        if(scv1 < 0) return solve(0, scv2, scv3);
        if(scv2 < 0) return solve(scv1, 0, scv3);
        if(scv3 < 0) return solve(scv1, scv2, 0);

        if(scv1 == 0 && scv2 == 0 && scv3 == 0) return 0;

        if(dp[scv1][scv2][scv3] != -1) return dp[scv1][scv2][scv3];

        int min = Integer.MAX_VALUE;

        min = Math.min(min, solve(scv1 - 9, scv2 - 3, scv3 - 1) + 1);
        min = Math.min(min, solve(scv1 - 9, scv2 - 1, scv3 - 3) + 1);
        min = Math.min(min, solve(scv1 - 3, scv2 - 9, scv3 - 1) + 1);
        min = Math.min(min, solve(scv1 - 3, scv2 - 1, scv3 - 9) + 1);
        min = Math.min(min, solve(scv1 - 1, scv2 - 9, scv3 - 3) + 1);
        min = Math.min(min, solve(scv1 - 1, scv2 - 3, scv3 - 9) + 1);

        return dp[scv1][scv2][scv3] = min;
    }
}