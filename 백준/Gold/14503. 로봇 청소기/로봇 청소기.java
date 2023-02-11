import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int[][] graph;
    static int n,m;
    static int r,c,d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int sight;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        graph = new int[n][m];

        strs = br.readLine().split(" ");
        r = Integer.parseInt(strs[0]);
        c = Integer.parseInt(strs[1]);
        d = Integer.parseInt(strs[2]);

        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }

        while (true) {
            if (graph[r][c] == 0) {
                graph[r][c] = 2;
            }

            if (graph[r + 1][c] != 0
                    && graph[r - 1][c] != 0
                    && graph[r][c + 1] != 0
                    && graph[r][c - 1] != 0) {
                if(graph[r-dx[d]][c-dy[d]] == 1) break;
                else {
                    r -= dx[d];
                    c -= dy[d];
                }
            }else{
                d = (d+3) % 4;
                if (graph[r + dx[d]][c + dy[d]] == 0) {
                    r += dx[d];
                    c += dy[d];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 2) {
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }
}
