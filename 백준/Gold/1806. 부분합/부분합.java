import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import static java.util.Arrays.stream;

class Main {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        arr = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                sum -= arr[left++];
            } else if (right == N) {
                break;
            }else{
                sum += arr[right++];
            }
            if (sum >= S) {
                min = Math.min(min, right - left);
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}