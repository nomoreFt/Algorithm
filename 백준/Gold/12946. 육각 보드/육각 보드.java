import java.io.*;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;


class Main {
    static int N;
    static char[][] graph;
    static int[][] color;
    static int ans = 0;
    static int[] dx = {-1,-1,0,0,1,1};
    static int[] dy = {0,1,-1,1,-1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];
        color = new int[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'X' && color[i][j] == 0) {
                    dfs(i, j,1);
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int col) {
        color[x][y] = col;
        ans = Math.max(ans, 1);
        for (int k = 0; k < 6; k++) {
            int nX = x + dx[k];
            int nY = y + dy[k];
            if (0 <= nX && nX < N && 0 <= nY && nY < N) {
                if (graph[nX][nY] == 'X') {
                    if (color[nX][nY] == 0) {
                        dfs(nX, nY, 3 - col);
                    }
                    //인접한 칸에 색칠된 컬러가 1개라도 있을 경우
                    ans = Math.max(ans, 2);
                    if (color[nX][nY] == col) {
                        ans = Math.max(ans, 3);
                    }
                }
            }
        }
    }
}
