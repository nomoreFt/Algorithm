import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int[] D = new int[n];

        Arrays.fill(D,1);
        for (int i = 1; i <= n-1; i++) {
            for (int k = i-1; k >= 0; k--) {
                if (A[i] > A[k]) {
                    D[i] = Math.max(D[k] + 1, D[i]);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if(ans < D[i])
                ans = D[i];
        }
        System.out.println(ans);
    }
}



