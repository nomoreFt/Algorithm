import java.io.*;
import java.util.*;


public class Main {
    static int n,m;
    static int[][] graph;
    static int[][] dist;
    static int[] dx = {0,0,-1,1,1,1,-1,-1};
    static int[] dy = {-1,1,0,0,-1,1,-1,1};
    static ArrayList<Node> sharks = new ArrayList<Node>();
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        graph = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            strs  = br.readLine().split(" ");
            Arrays.fill(dist[i],-1);
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
                if (graph[i][j] == 1) {
                    dist[i][j] = 0;
                    sharks.add(new Node(i, j));
                }
            }
        }

        for (Node shark : sharks) {
            boolean[][] visited = new boolean[n][m];
            Queue<Node> q = new LinkedList<>();
            q.offer(shark);
            visited[shark.x][shark.y] = true;
            dist[shark.x][shark.y] = 0;

            while (!q.isEmpty()) {
                Node now = q.poll();

                for (int i = 0; i < 8; i++) {
                    int nX = dx[i] + now.x;
                    int nY = dy[i] + now.y;

                    if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                    if (!visited[nX][nY]) {
                        q.offer(new Node(nX, nY));
                        if (dist[nX][nY] == -1) {
                            dist[nX][nY] = dist[now.x][now.y] + 1;
                        }else{
                            dist[nX][nY] = Math.min(dist[nX][nY], dist[now.x][now.y] + 1);
                        }
                        visited[nX][nY] = true;
                    }
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    ans = Math.max(ans, dist[i][j]);
            }
        }
        System.out.println(ans);
    }
}
