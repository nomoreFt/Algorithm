import java.io.*;
import java.util.Arrays;

class Main {
    static int n;
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        D = new int[n + 1];
        Arrays.fill(D,100001);
        D[0] = 0;
        D[1] = 1;


        for (int i = 2; i <= n; i++) {
            for (int k = 0; k * k  <= i; k++) {
                D[i] = Math.min(D[i], D[i -k * k] + 1);
            }
        }

        System.out.println(D[n]);
    }

}



