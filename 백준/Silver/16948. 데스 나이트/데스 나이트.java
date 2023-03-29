
import java.util.*;

class Main {
    static int n;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, +1, -2, 2, -1, 1};
    static int startX,startY,endX,endY;
    static int[][] dist;
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        startX = sc.nextInt();
        startY = sc.nextInt();
        endX = sc.nextInt();
        endY = sc.nextInt();

        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],-1);
        }

        bfs();

        System.out.println(dist[endX][endY]);

    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX,startY));
        dist[startX][startY] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 6; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];

                if (0 <= nX && nX < n && 0 <= nY && nY < n) {
                    if (dist[nX][nY] == -1) {
                        dist[nX][nY] = dist[now.x][now.y] + 1;
                        q.offer(new Node(nX, nY));
                    }
                }
            }
        }
    }

}