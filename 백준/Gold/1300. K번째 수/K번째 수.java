import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
    static long N, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        long left = 1;
        long right = N * N;
        long ans = 0;
        while(left <= right) {
            long mid = (right - left) / 2 + left;
            long lowCnt = calcuateCnt(mid);
            if(lowCnt >= k) {
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static long calcuateCnt(long mid) {
        long cnt = 0;
        for(int i = 1; i <= N; i++){
            cnt += Math.min(N, mid/i);
        }
        return cnt;
    }
}

