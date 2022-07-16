import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    static String[][] graph;
    static Queue<Node> waterList = new LinkedList<>();
    static Queue<Node> q = new LinkedList<>();
    static boolean[][] visited;
    static int cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        int cnt = 0;
    }

    static Node Beaver;
    static Node Gosum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        r = Integer.parseInt(strs[0]);
        c = Integer.parseInt(strs[1]);
        graph = new String[r][c];
        visited = new boolean[r][c];




        for (int i = 0; i < r; i++) {
            strs = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                graph[i][j] = strs[j];
                if (strs[j].equals("*")) {

                    waterList.offer(new Node(i, j));
                    visited[i][j] = true;
                }
                if (strs[j].equals("D")) Beaver = new Node(i, j);
                if (strs[j].equals("S")) Gosum = new Node(i, j);
            }
        }
        q.offer(Gosum);

        visited[Gosum.x][Gosum.y] = true;
        bfs();
        System.out.println("KAKTUS");
    }
    static void bfs() {
        while (!q.isEmpty()) {
            //물길 퍼트림
            int waterSize = waterList.size();
            for (int t = 0; t < waterSize; t++) {
                Node water = waterList.poll();
                for (int i = 0; i < 4; i++) {
                    int nX = dx[i] + water.x;
                    int nY = dy[i] + water.y;

                    if(nX < 0 || nX >= r || nY < 0 || nY >= c) continue;
                    if (graph[nX][nY].equals(".")) {
                        graph[nX][nY] = "*";
                        waterList.offer(new Node(nX, nY));
                    }
                }
            }

            int qSize = q.size();
            for (int t = 0; t < qSize; t++) {
                Node G = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nX = dx[i] + G.x;
                    int nY = dy[i] + G.y;

                    if(nX < 0 || nX >= r || nY < 0 || nY >= c) continue;
                    if (graph[nX][nY].equals("D")) {
                        System.out.println(G.cnt+1);
                        System.exit(0);
                    } else if (graph[nX][nY].equals(".")) {
                        graph[nX][nY] = "S";
                        q.offer(new Node(nX, nY, G.cnt + 1));
                    }
                }
            }

        }
    }
}

