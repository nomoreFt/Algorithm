import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long ans = 0;

        for(int start = 1,len = 1; start<=N; start *=10, len++){
            int end = start * 10 -1;

            if (end > N) {
                end = N;
            }
            ans += (long)(end - start + 1) * len;
        }
        System.out.println(ans);
    }
}



