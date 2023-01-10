import java.io.*;
import java.util.*;

class Main {
    static class Vertex{
        int x,y;

        Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] graph;
    static boolean[][] visited;
    static int n,m;
    public static void bfs() {
        Queue<Vertex> q = new LinkedList<>();
        q.offer(new Vertex(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Vertex now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];
                if (nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                if (!visited[nX][nY] && graph[nX][nY] == 1) {
                    visited[nX][nY] = true;
                    q.offer(new Vertex(nX, nY));
                    graph[nX][nY] = graph[now.x][now.y] + 1;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        graph = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            strs = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }

        bfs();

        System.out.println(graph[n-1][m-1]);
    }
}




