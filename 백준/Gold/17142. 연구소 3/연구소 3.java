import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n,m;
    static int[][] graph;
    static int[][] dist;
    static int ans = -1;
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Node> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        graph = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],-1);
        }
        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
                if (graph[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }

        go(0, 0);
        System.out.println(ans);


    }

    private static void go(int idx, int cnt) {
        if (idx == virus.size()) {
            if (cnt == m) {
                bfs();
            }
        }else{
            Node now = virus.get(idx);
            graph[now.x][now.y] = 3;
            go(idx+1,cnt+1);
            graph[now.x][now.y] = 2;
            go(idx + 1, cnt);
        }

    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    private static void bfs() {
        int[][] dist = new int[n][n];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 3) {
                    dist[i][j] = 0;
                    q.offer(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = dx[i] + now.x;
                int nY = dy[i] + now.y;

                if(nX < 0 || nX >= n || nY < 0 || nY >= n) continue;
                if(graph[nX][nY] == 1) continue;
                if (dist[nX][nY] == -1) {
                        dist[nX][nY] = dist[now.x][now.y]+1;
                        q.offer(new Node(nX, nY));
                }
            }
        }

        int cur = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
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


