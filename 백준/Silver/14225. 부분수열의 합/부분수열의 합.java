import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int total = Arrays.stream(arr).sum();
        visited = new boolean[total+10];
        go(0, 0);

        for (int i = 1; i <= total+10; i++) {
            if (!visited[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void go(int idx, int sum) {
        if (idx == N) {
            visited[sum] = true;
            return;
        }
        go(idx+1, sum+arr[idx]);
        go(idx+1, sum);

    }
}