import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static String[] strs;
    static int w,h = 0;
    static int[] nX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] nY = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] graph;
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
        StringBuilder sb = new StringBuilder();
        strs = br.readLine().split(" ");
        w = Integer.parseInt(strs[0]);
        h = Integer.parseInt(strs[1]);

        while (w != 0 && h != 0) {
            graph = new int[h][w];
            int sumCnt = 0;
            //지도 초기화
            for (int i = 0; i < h; i++) {
                strs = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(strs[j]);
                }
            }

            //bfs 수행

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] != 0) {
                        sumCnt++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(sumCnt + "\n");

            strs = br.readLine().split(" ");
            w = Integer.parseInt(strs[0]);
            h = Integer.parseInt(strs[1]);
        }
        System.out.println(sb.toString());
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        graph[x][y] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            //8방 돌면서 link되어있는지 체크
            for (int i = 0; i < nX.length; i++) {
                int nextX = nX[i] + node.x;
                int nextY = nY[i] + node.y;
                if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue;
                if (graph[nextX][nextY] == 1) {
                    graph[nextX][nextY] = 0;
                    q.offer(new Node(nextX, nextY));
                }
            }
        }
    }
}