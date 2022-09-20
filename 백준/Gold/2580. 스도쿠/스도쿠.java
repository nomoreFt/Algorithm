import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] graph = new int[9][9];
    static ArrayList<Node> targets = new ArrayList<>();
    static int size;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
                if(graph[i][j] == 0) targets.add(new Node(i, j));
            }
        }
        size = targets.size();

        dfs(0);
    }
    static void dfs(int depth) {
        if (depth == size) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        Node now = targets.get(depth);
        int nowX = now.x;
        int nowY = now.y;
        for (int i = 1; i <= 9; i++) {
            if (possibility(now, i)) {
                graph[now.x][now.y] = i;
                dfs(depth + 1);
                graph[now.x][now.y] = 0;
            }
        }
    }

    static boolean possibility(Node now, int value) {
        for (int i = 0; i < 9; i++) {
            if (Math.abs(graph[now.x][i]-value)==0) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Math.abs(graph[i][now.y]-value) == 0) {
                return false;
            }
        }

        int nowX = (now.x / 3) * 3;
        int nowY = (now.y / 3) * 3;

        for (int i = nowX; i < nowX + 3; i++) {
            for (int j = nowY; j < nowY + 3; j++) {
                if (Math.abs(graph[i][j]-value) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

