import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);

        int[] arr = new int[N];
        strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        int s = 0, e = 0, sum = 0, cnt = 0;
        //투포인터
        while (true) {
            if (sum >= M) {
                sum -= arr[s++];
            }else if(e == N) break; //e가 N이어도 이전에 sum >= M 인 경우 
            else{
                sum += arr[e++];
            }
            if (sum == M) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}