import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int h, w;
    static int[][] graph;
    static String[] strs;
    static Queue<Node> link = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strs = br.readLine().split(" ");
        w = Integer.parseInt(strs[0]);
        h = Integer.parseInt(strs[1]);

        graph = new int[h][w];

        for (int i = 0; i < h; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
                if (graph[i][j] == 1) link.offer(new Node(i, j));
            }
        }

        while (!link.isEmpty()) {
            Node poll = link.poll();
            for (int i = 0; i < 4; i++) {
                int nX = dx[i] + poll.x;
                int nY = dy[i] + poll.y;
                if(nX < 0 || nX >= h || nY < 0 || nY >= w) continue;
                if (graph[nX][nY] == 0) {
                    graph[nX][nY] = graph[poll.x][poll.y] +1;
                    link.add(new Node(nX, nY));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (graph[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                max = Math.max(max, graph[i][j]);
            }
        }
        System.out.println(max -1);


    }
}