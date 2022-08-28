import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    static int N;
    static int[] arr;
    static int[] dpL;
    static int[] dpR;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        arr = new int[N + 1];
        dpL = new int[N + 1];
        dpR = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(s[i]);
            dpL[i + 1] = 1;
            dpR[i + 1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dpL[i] = Math.max(dpL[i], dpL[j] + 1);
                }
            }
        }
        for (int i = N; i >= 1; i--) {
            for (int j = N; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dpR[i] = Math.max(dpR[i], dpR[j]+1);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(dpL[i] + dpR[i] - 1, max);
        }
        System.out.println(max);
    }
}
