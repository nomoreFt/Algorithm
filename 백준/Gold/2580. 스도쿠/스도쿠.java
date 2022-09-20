import java.io.*;
import java.sql.Array;
import java.time.chrono.MinguoChronology;
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
    //arr[depth열] = 값(행) ex) arr[0] = 1  (0,1)에 체스가 위치
    static void dfs(int depth) {
        //depth +1 될 때 마다 왼쪽에서 오른쪽으로 진행이다. 전체 진행 완료란 의미
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
        int nowRow = now.x;
        int nowCol = now.y;
        for (int i = 1; i <= 9; i++) {
            if (possibility(nowRow, nowCol, i)) {
                graph[nowRow][nowCol] = i;
                dfs(depth + 1);
                graph[nowRow][nowCol] = 0;
            }
        }
    }

    static boolean possibility(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (graph[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (graph[i][col] == value) {
                return false;
            }
        }

        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (graph[i][j] == value) {
                    return false;
                }
            }
        }

        return true;

    }
}

