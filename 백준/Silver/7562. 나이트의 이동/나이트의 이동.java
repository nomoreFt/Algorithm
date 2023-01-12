import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static class Edge{
        int x, y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int l;
    static int[][] graph;
    static final int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static final int[] dy = {1,2,2,1,-1,-2,-2,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] strs;
        while (T-- > 0) {
            l = Integer.parseInt(br.readLine());
            graph = new int[l][l];
            strs = br.readLine().split(" ");
            int startX = Integer.parseInt(strs[0]);
            int startY = Integer.parseInt(strs[1]);

            for (int i = 0; i < l; i++) {
                Arrays.fill(graph[i],-1);
            }
            Queue<Edge> q = new LinkedList<>();
            q.offer(new Edge(startX, startY));
            graph[startX][startY] = 0;

            while (!q.isEmpty()) {
                Edge now = q.poll();
                for (int i = 0; i < 8; i++) {
                    int nX = now.x + dx[i];
                    int nY = now.y + dy[i];
                    if(nX < 0 || nX >= l || nY < 0 || nY >= l) continue;
                    if (graph[nX][nY] == -1) {
                        graph[nX][nY] = graph[now.x][now.y] + 1;
                        q.offer(new Edge(nX, nY));
                    }
                }
            }

            strs = br.readLine().split(" ");
            int endX = Integer.parseInt(strs[0]);
            int endY = Integer.parseInt(strs[1]);
            System.out.println(graph[endX][endY]);
        }
    }
}