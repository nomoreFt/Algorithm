import java.io.*;
import java.util.Arrays;

class Main {
    static int[] A;
    static int[] D;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N];
        A = new int[N];
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(strs[i]);
            D[i] = Integer.parseInt(strs[i]);
            
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && D[i] < D[j] + A[i]) {
                    D[i] = D[j] + A[i];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, D[i]);
        }
        System.out.println(ans);

    }
}



