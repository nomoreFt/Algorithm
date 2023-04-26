import java.util.*;
import java.io.*;
public class Main {
    static int T;
    static int[] arr;
    static int[][] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            arr = new int[K+1];
            dist = new int[K + 1][K + 1];
            String[] strs = br.readLine().split(" ");
            for (int i = 1; i <= K; i++) {
                arr[i] = Integer.parseInt(strs[i-1]);
                Arrays.fill(dist[i], -1);
            }


            System.out.println(go(1,K));
        }
    }

    private static int go(int start, int end) {

        if(start == end){
            return 0;
        }

        if (dist[start][end] != -1) {
            return dist[start][end];
        }

        int ans = -1;
        int sum = 0;
        for (int k = start; k <= end; k++) {
            sum += arr[k];
        }

        for (int k = start; k <= end - 1; k++) {
            int temp = go(start,k) + go(k+1,end) + sum;
            if (ans == -1 || ans > temp) {
                ans = temp;
            }
        }

        dist[start][end] = ans;
        return ans;




    }
}