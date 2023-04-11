import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n,m;
    static char[][] graph;
    static int[][] dist;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        m = Integer.parseInt(strs[0]);
        n = Integer.parseInt(strs[1]);

        graph = new char[n][m];
        dist = new int[n][m];


        Node mirror1 = null;
        Node mirror2 = null;

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
                graph[i][j] = chars[j];
                if (graph[i][j] == 'C') {
                    if (mirror1 == null) {
                        mirror1 = new Node(i, j);
                    }else{
                        mirror2 = new Node(i, j);
                    }
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(mirror1);
        dist[mirror1.x][mirror1.y] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                    int nX = now.x + dx[i];
                    int nY = now.y + dy[i];

                while (0 <= nX && nX < n && 0 <= nY && nY < m && graph[nX][nY] != '*') {
                    if (dist[nX][nY] == -1) {
                        dist[nX][nY] = dist[now.x][now.y]+1;
                        q.offer(new Node(nX, nY));
                    }
                    nX += dx[i];
                    nY += dy[i];
                }
            }
        }
        System.out.println(dist[mirror2.x][mirror2.y]-1);
    }
}

