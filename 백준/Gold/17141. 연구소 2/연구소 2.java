import java.io.*;
import java.util.*;


public class Main {
    static int n,m;
    static int[][] graph;
    static ArrayList<Node> candi = new ArrayList<Node>();

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int ans = -1;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
                if (graph[i][j] == 2) {
                    graph[i][j] = 0;
                    candi.add(new Node(i, j));
                }
            }
        }

        go(0, 0);
        System.out.println(ans);


    }

    private static void go(int idx, int cnt) {
        if (idx == candi.size()) {
            if (cnt == m) {
                bfs();
            }
        }else{
            Node now = candi.get(idx);
            graph[now.x][now.y] = 3;
            go(idx + 1, cnt + 1);
            graph[now.x][now.y] = 0;
            go(idx + 1, cnt);
        }
    }


    private static void bfs() {
        Queue<Node> q = new LinkedList<>();

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 3) {
                    q.offer(new Node(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];

                if(nX < 0 || nX >= n || nY < 0 || nY >= n) continue;
                if (graph[nX][nY] != 1 && dist[nX][nY] == -1) {
                    q.offer(new Node(nX, nY));
                    dist[nX][nY] = dist[now.x][now.y]+1;
                }
            }
        }

        int cur = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 1) {
                    if(dist[i][j] == -1) return;
                    cur = Math.max(cur, dist[i][j]);
                }
            }
        }
        if (ans == -1 || ans > cur) {
            ans = cur;
        }
    }


}


