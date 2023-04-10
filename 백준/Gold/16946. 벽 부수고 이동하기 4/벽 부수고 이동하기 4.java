import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] graph;
    static int[][] temp;
    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Node> walls = new ArrayList<>();
    static HashMap<Integer,Integer> groupCntMap = new HashMap();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);

        graph = new int[n][m];
        temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            strs = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
                temp[i][j] = Integer.parseInt(strs[j]);
                if (graph[i][j] == 1) {
                    walls.add(new Node(i, j));
                }
            }
        }

        //그룹 표시하기
        //2번부터 그룹

        int groupNumber = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    setGroupNumber(new Node(i, j),groupNumber++);
                }
            }
        }

        for (Node tmp : walls) {
            int cnt = 1;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                int nX = tmp.x + dx[i];
                int nY = tmp.y + dy[i];
                if (0 <= nX && nX < n && 0 <= nY && nY < m) {
                    if (graph[nX][nY] >= 2) {
                        set.add(graph[nX][nY]);
                    }
                }
            }
            for (int t : set) {
                cnt += groupCntMap.get(t);
            }
            temp[tmp.x][tmp.y] = cnt%10;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(String.valueOf(temp[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static void setGroupNumber(Node node,int groupNumber) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int cnt = 1;
        graph[node.x][node.y] = groupNumber;
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];

                if (0 <= nX && nX < n && 0 <= nY && nY < m && graph[nX][nY] == 0) {
                    graph[nX][nY] = groupNumber;
                    q.offer(new Node(nX, nY));
                    cnt++;
                }
            }
        }
        groupCntMap.put(groupNumber, cnt);
    }
}