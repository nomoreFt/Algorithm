import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] graph;
    static int[][] danjiGraph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Edge {
        int x;
        int y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int danji) {
        Queue<Edge> q = new LinkedList<>();
        danjiGraph[x][y] = danji;
        q.offer(new Edge(x, y));
        while (!q.isEmpty()) {
            Edge now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];
                if(nX < 0 || nX >= n || nY < 0 || nY >= n) continue;
                if (danjiGraph[nX][nY] == 0 && graph[nX][nY] == 1) {
                    danjiGraph[nX][nY] = danji;
                    q.offer(new Edge(nX, nY));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        danjiGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int danji = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(danjiGraph[i][j] == 0 && graph[i][j] == 1)
                bfs(i, j, ++danji);
            }
        }
        int[] ans = new int[danji];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (danjiGraph[i][j] != 0) {
                    ans[danjiGraph[i][j]-1]++;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(danji);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}




