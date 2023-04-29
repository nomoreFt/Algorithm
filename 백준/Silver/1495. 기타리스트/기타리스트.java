import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
     static int N,S,M;
     static int[] volumeList;
     static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        S = Integer.parseInt(strs[1]);
        M = Integer.parseInt(strs[2]);

        volumeList = new int[N+1];
        dp = new int[N+1][M+1];

        strs = br.readLine().split(" ");
        for(int i=1;i<=N;i++){
            volumeList[i] = Integer.parseInt(strs[i-1]);
        }
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }


        dp[0][S] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if(dp[i-1][j] == -1) continue;
                if (j + volumeList[i] <= M) {
                    dp[i][j+volumeList[i]] = 9;
                }
                if (j - volumeList[i] >= 0) {
                    dp[i][j-volumeList[i]] = 9;
                }
            }
        }

        int ans = -1;

        for (int i = 0; i <= M; i++) {
            if(dp[N][i] == 9) ans = i;
        }
        System.out.println(ans);
    }




}