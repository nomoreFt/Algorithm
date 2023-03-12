import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class Main {
    static int N;
    static int[] arr;
    static int[] cals;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        cals = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        go(arr[0], 1, cals[0], cals[1], cals[2], cals[3]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void go(int sum, int idx, int plus, int min, int mul, int div){
        if (idx == N) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }
        if (plus > 0) {
            go(sum + arr[idx], idx + 1, plus - 1, min, mul, div);
        }

        if (min > 0) {
            go(sum - arr[idx], idx + 1, plus , min-1, mul, div);
        }

        if (mul > 0) {
            go(sum * arr[idx], idx + 1, plus , min, mul -1, div);
        }

        if (div > 0) {
            go(sum / arr[idx], idx + 1, plus, min, mul, div - 1);
        }
    }

}
