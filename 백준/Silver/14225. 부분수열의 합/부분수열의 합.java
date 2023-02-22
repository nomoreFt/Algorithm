import java.io.*;
import java.util.*;


class Main {
    static int  N;
    static boolean[] visited = new boolean[2000000];
    static int[] arr;



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0);

        for (int i = 0; i < 2000000; i++) {
            if(!visited[i]){ System.out.println(i);
            break;}
        }
    }

    public static void dfs(int idx, int sum) {
        if (idx == N) {
            visited[sum] = true;
            return;
        }
        dfs(idx + 1,  sum + arr[idx]);
        dfs(idx + 1,  sum);

    }
}