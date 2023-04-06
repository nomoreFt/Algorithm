import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static char[][] graph = new char[8][8];
    static int[] dx = {1,-1,0,0,1,1,-1,-1,0};
    static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1,0};
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            graph[i] = br.readLine().toCharArray();

        }



        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(7, 0));
        int time = 0;
        boolean ans = false;
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> set = new HashSet<>();

            for (int t = 0; t < size; t++) {
                Node now = q.poll();
                int x = now.x;
                int y = now.y;
                if(x == 0 && y == 7) {
                    System.out.println(1);
                    System.exit(0);
                }
                for (int i = 0; i < 9; i++) {
                    int nX = x + dx[i];
                    int nY = y + dy[i];
                    if(nX < 0 || nX >= 8 || nY < 0 || nY >= 8) continue;
                    if(graph[nX][nY] == '#') continue;
                    if(nX-1 >= 0 && graph[nX-1][nY] == '#') continue;
                    if (!set.contains(nX + "_" + nY)) {
                        set.add(nX + "_" + nY);
                        q.offer(new Node(nX, nY));
                    }
                }
            }
            time++;
            if (time < 9) {
                moveWall();
            }
        }
        System.out.println(0);
    }

    private static void moveWall() {
        char[][] clone = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                clone[i][j] = graph[i][j];
            }
        }

        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph[i][j] = clone[i - 1][j];
            }
        }
        for (int i = 0; i < 8; i++) {
            graph[0][i] = '.';
        }
    }
}