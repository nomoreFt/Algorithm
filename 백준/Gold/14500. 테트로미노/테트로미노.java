import java.io.*;
import java.util.*;


class Main {
    static int N, M;
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                go(i, j, 0, 0);
                if (j + 2 < M) {
                    int temp = graph[i][j] + graph[i][j + 1] + graph[i][j + 2];
                    if (i - 1 >= 0) {
                        int temp2 = temp + graph[i - 1][j + 1];
                        MAX = Math.max(MAX, temp2);
                    }
                    if (i + 1 < N) {
                        int temp2 = temp + graph[i + 1][j + 1];
                        MAX = Math.max(MAX, temp2);
                    }
                }
                if (i + 2 < N) {
                    int temp = graph[i][j] + graph[i + 1][j] + graph[i + 2][j];
                    if (j - 1 >= 0) {
                        int temp2 = temp + graph[i + 1][j - 1];
                        MAX = Math.max(MAX, temp2);
                    }
                    if (j + 1 < M) {
                        int temp2 = temp + graph[i + 1][j + 1];
                        MAX = Math.max(MAX, temp2);
                    }
                }
            }
        }
        System.out.println(MAX);

    }

    private static void go(int x, int y, int sum, int depth) {
        if (depth == 4) {
            MAX = Math.max(MAX, sum);
            return;
        }
        if(x < 0 || x >= N || y < 0 || y >= M) return;
        if(visited[x][y]) return;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            go(nX, nY, sum + graph[x][y], depth + 1);
        }
        visited[x][y] = false;
    }
}
