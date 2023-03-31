
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n,m,k;

    static int[][] graph;
    static int[][][] dist;
    static class Node{
        int x;
        int y;
        int z;
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        k = Integer.parseInt(strs[2]);

        graph = new int[n][m];
        dist = new int[n][m][k+1];
        for (int i = 0; i < n; i++) {
            graph[i] =  Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt)
                    .toArray();
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int z = now.z;

            for (int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];

                if (0 <= nX && nX < n && 0 <= nY && nY < m) {

                    //빈칸일 경우
                    if (graph[nX][nY] == 0 && dist[nX][nY][z] == 0) {
                        q.offer(new Node(nX, nY, z));
                        dist[nX][nY][z] = dist[x][y][z]+1;
                    }
                    //벽일 경우
                    if (z+1 <= k && graph[nX][nY] == 1 && dist[nX][nY][z + 1] == 0) {
                        q.offer(new Node(nX, nY, z + 1));
                        dist[nX][nY][z+1] = dist[x][y][z]+1;
                    }

                }
            }
        }
            int ans = -1;
            for (int i = 0; i <= k; i++) {
                if(dist[n-1][m-1][i] == 0) continue;
                if (ans == -1) {
                    ans = dist[n - 1][m - 1][i];
                } else if (ans > dist[n - 1][m - 1][i]) {
                    ans = dist[n - 1][m - 1][i];
                }
            }

            System.out.print(ans);
    }
}