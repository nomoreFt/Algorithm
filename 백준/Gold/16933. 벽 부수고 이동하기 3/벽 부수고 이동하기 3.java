import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n,m,k;
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][][] visited;

    static class Node{
        int x;
        int y;
        int wall;
        int dist;
        int night;
        public Node(int x,int y, int wall,int dist, int night) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.dist = dist;
            this.night = night;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        k = Integer.parseInt(strs[2]);

        graph = new int[n][m];
        visited = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            strs = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }
        int ans = -1;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0,1,1));

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int wall = now.wall;
            int dist = now.dist;
            int night = now.night;
            if (x == n - 1 && y == m - 1) {
                ans = dist;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];

                if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;

                if (graph[nX][nY] == 0 && !visited[nX][nY][wall]) {
                    visited[nX][nY][wall] = true;
                    q.offer(new Node(nX, nY, wall, dist + 1, 1 - night));
                } else if (graph[nX][nY] == 1 && wall + 1 <= k && !visited[nX][nY][wall + 1]) {
                    if (night == 1) {
                        //낮
                        visited[nX][nY][wall+1] = true;
                        q.offer(new Node(nX, nY, wall + 1, dist + 1, 1 - night));
                    }else{
                        q.offer(new Node(x, y, wall, dist + 1, 1 - night));
                    }
                }
            }
        }

        System.out.println(ans);
    }
}