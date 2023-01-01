import java.io.*;
import java.util.Arrays;

class Main {
    static int[] D;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1];
        D[0] = 1;

        for (int i = 2; i <= N; i+=2) {
            D[i] += D[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                D[i] += D[j] * 2;
            }
        }
        System.out.println(D[N]);

    }
}



