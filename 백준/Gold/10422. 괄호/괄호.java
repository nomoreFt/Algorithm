import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static long[] dp = new long[5001];
    static final long MOD =1000000007;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Arrays.fill(dp, -1);
        while (T-- > 0) {
            int L = Integer.parseInt(br.readLine());

            if(L % 2 == 1) {
                System.out.println(0);
            }else{
                System.out.println(go(L));
            }

        }

    }

    private static long go(int l) {
        if(l == 0) return 1;
        if(dp[l] != -1) return dp[l];

        dp[l] = 0;
        for(int i = 2; i <= l; i+=2) {
            dp[l] += go(i-2) * go(l-i);
            dp[l] %= MOD;
        }
        return dp[l];
    }

}