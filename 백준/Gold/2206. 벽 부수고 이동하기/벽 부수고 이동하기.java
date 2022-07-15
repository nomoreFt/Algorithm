import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    static int n,m;
    static int[][] graph;
    static boolean[][][] visited;
    static class Node {
        int x;
        int y;
        int cnt;
        boolean destroyed;

        public Node(int x, int y, int cnt,boolean dist) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed = dist;
        }
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            strs = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }

        bfs();
        System.out.println(-1);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[n][m][2];
        q.offer(new Node(0, 0, 1, false));

        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if (node.x == n - 1 && node.y == m - 1) {
                System.out.println(node.cnt);
                System.exit(0);

            }

            for (int i = 0; i < 4; i++) {
                int nX = dx[i] + node.x;
                int nY = dy[i] + node.y;

                if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
               // System.out.println("nX ,nY = " + nX + ", " + nY);
                if (graph[nX][nY] == 0) {//벽이 아닌 경우
                    if (!node.destroyed && !visited[nX][nY][0]) {//부신 벽이 없으면,
                        q.add(new Node(nX, nY, node.cnt + 1, false));
                        visited[nX][nY][0] = true;
                    } else if (node.destroyed && !visited[nX][nY][1]) {
                        q.add(new Node(nX, nY, node.cnt + 1, true));
                        visited[nX][nY][1] = true;
                    }
                } else if (graph[nX][nY] == 1) {
                    if (!node.destroyed) {
                        q.add(new Node(nX, nY, node.cnt + 1, true));
                        visited[nX][nY][1] = true;
                    }
                }
            }
        }

    }
}

