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
        String[] strs = br.readLine().split(" ");
        arr = new int[N+1];
        dp = new int[N+1];

        int arrLen = strs.length;
        for (int i = 1; i <= arrLen; i++) {
            arr[i] = Integer.parseInt(strs[i - 1]);
            dp[i] = 1;
        }

        int max = 1;
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 1; i <= arrLen; i++) {
            int last = 0;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(max + "\n");

        for (int i = N; i >= 1; i--) {
            if (dp[i] == max) {
                resultList.add(arr[i]);
                max--;
            }
        }

        Collections.sort(resultList);
        for (Integer integer : resultList) {
            sb.append(integer + " ");
        }
        System.out.println(sb.toString());
    }
}
