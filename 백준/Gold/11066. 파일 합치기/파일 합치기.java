import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    static int T;
    static int[] arr;
    static int[][] dist;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            arr = new int[k + 1];
            dist = new int[k + 1][k + 1];

            String[] strs = br.readLine().split(" ");
            for (int i = 1; i <= k; i++) {
                arr[i] = Integer.parseInt(strs[i - 1]);
                Arrays.fill(dist[i], -1);
            }

            System.out.println(solve(1, k));
        }


    }

    private static int solve(int start, int end) {
        if(start == end) return 0;
        if(dist[start][end] != -1) return dist[start][end];

        int ret = Integer.MAX_VALUE;
        int sum = 0;
        for (int k = start; k <= end; k++) {
            sum += arr[k];
        }
        for (int i = start; i < end; i++) {
            int temp = solve(start, i) + solve(i + 1, end) + sum;
            ret = Math.min(ret, temp);
        }

        return dist[start][end] = ret;

    }

}