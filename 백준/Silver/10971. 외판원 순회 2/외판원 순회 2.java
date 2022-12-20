import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static int N;
    static int[] result;
    static int[][] W;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];
        result = new int[N];
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(strs[j]);
            }
        }
        dfs(0);
        System.out.println(min);
    }
    public static void dfs(int idx) {
        if (idx == N) {
            calc();
            return;
        }
        if(idx > N) return;

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            result[idx] = i;
            visited[i] = true;
            dfs(idx + 1);
            visited[i] = false;
        }
    }

    static void calc() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            int sum1 = W[result[i]][result[i + 1]];
            if(sum1 == 0) return;
            sum += sum1;
        }

        int sum1 = W[result[result.length - 1]][result[0]];
        if(sum1 == 0) return;
        sum += sum1;
        min = Math.min(min, sum);
    }
}



