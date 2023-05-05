import java.io.*;
import java.util.Arrays;

class Main {
    static int[] A;
    static int[] D;
    static int[] D2;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N];
        D2 = new int[N];
        A = new int[N];

        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(strs[i]);
        }

        for (int i = 0; i < N; i++) {
            D[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && D[i] < D[j] + 1) {
                    D[i] = D[j] + 1;
                }
            }
        }
        for (int i = N-1; i >= 0; i--) {
            D2[i] = 1;
            for (int j = N-1; j > i; j--) {
                if (A[i] > A[j] && D2[i] < D2[j] + 1) {
                    D2[i] = D2[j] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans =  Math.max(ans, D[i] + D2[i] -1);
        }
        System.out.println(ans);
    }
}



