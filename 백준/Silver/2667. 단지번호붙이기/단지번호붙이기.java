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
    static int[][] danjiGraph;
    static int n;
    public static void bfs(Vertex now, int danji) {
        Queue<Vertex> q = new LinkedList<>();
        danjiGraph[now.x][now.y] = danji;
        q.offer(now);
        while (!q.isEmpty()) {
            Vertex next = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = next.x + dx[i];
                int nY = next.y + dy[i];
                if (nX < 0 || nX >= n || nY < 0 || nY >= n) continue;
                if (graph[nX][nY] == 1 && danjiGraph[nX][nY] == 0) {
                    danjiGraph[nX][nY] = danji;
                    q.offer(new Vertex(nX, nY));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        danjiGraph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }

        int danji = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && danjiGraph[i][j] == 0) {
                    danji++;
                    bfs(new Vertex(i, j), danji);
                }
            }
        }

        int[] ans = new int[danji];
        System.out.println(danji);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(danjiGraph[i][j] != 0)
                ans[danjiGraph[i][j]-1]++;
            }
        }
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);

        }
    }
}




