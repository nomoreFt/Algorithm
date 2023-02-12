import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int n, m;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        graph = new int[102][102];

        for (int i = 1; i <= n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(strs[j-1]);
            }
        }

        int ans = 2* n * m;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < 4; k++) {
                    int nX = i + dx[k];
                    int nY = j + dy[k];

                    if(graph[i][j] - graph[nX][nY] >= 0)
                        ans += graph[i][j] - graph[nX][nY];
                }
            }
        }

        System.out.println(ans);
    }
}
