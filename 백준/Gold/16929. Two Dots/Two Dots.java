import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class Main {
    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);

        graph = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) continue;
                if(dfs(i, j, -1, -1, graph[i][j])){
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("No");
    }

    private static boolean dfs(int x, int y, int px, int py, char color) {
        if (visited[x][y]) {
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nX = dx[i] + x;
            int nY = dy[i] + y;
            if(nX == px && nY == py) continue;
            if(nX < 0 || nX >= N || nY < 0 || nY >= M) continue;
            if(color != graph[nX][nY]) continue;

            if (dfs(nX, nY, x, y, color)) {
                return true;
            }
        }
        return false;
    }
    static boolean go(int x, int y, int px, int py, char color) {
        if (visited[x][y]) {
            return true;
        }
        visited[x][y] = true;
        for (int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (!(nx == px && ny == py)) {
                    if (graph[nx][ny] == color) {
                        if (go(nx, ny, x, y, color)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
