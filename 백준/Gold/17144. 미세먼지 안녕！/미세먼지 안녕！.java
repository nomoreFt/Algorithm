import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R,C,T;
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Node> airCondition = new ArrayList<Node>();

    public static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);

        graph = new int[R][C];

        for (int i = 0; i < R; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                if (graph[i][j] == -1) {
                    airCondition.add(new Node(i,j));
                    graph[i][j] = 0;
                }
            }

        }


        while (T-- > 0) {
            spreadDust();
            spreadAir();
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph[i][j] != -1) {
                    ans += graph[i][j];
                }
            }
        }

        System.out.println(ans);

    }

    private static void spreadAir() {
        int[][] temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp[i] = graph[i].clone();
        }

        Node upMachine = airCondition.get(0);
        Node downMachine = airCondition.get(1);

        //upMachine(2,0)
        //downMachine(3,0)

        // upMachine - right
        //(2,0) (2,1) (2,2) (2,3) (2,4) (2,5) (2,6) (2,7)
        for (int i = upMachine.y; i < C-1; i++) {
            graph[upMachine.x][i + 1] = temp[upMachine.x][i];
        }
        // downMachine - right
        for (int i = downMachine.y; i < C-1; i++) {
            graph[downMachine.x][i + 1] = temp[downMachine.x][i];
        }

        //upMachine - up
        //(2,7) (1,7) (0,7)
        for(int i = upMachine.x-1; 0 <= i; i--){
            graph[i][C - 1] = temp[i + 1][C - 1];
        }
        //downMachine - down
        //(3,7)(4,7)(5,7)
        for(int i = downMachine.x; i < R-1; i++){
            graph[i + 1][C-1] = temp[i][C-1];
        }


        //upMachine - left
        //(0,7)(0,6) (0,5) (0,4) (0,3) (0,2) (0,1) (0,0)
        for(int i = C-2; i >= 0; i--){
            graph[0][i] = temp[0][i + 1];
        }
        //downMachine - left
        //(6,7)(6,6)(6,5)(6,4)...(6,0)
        for(int i = C-1; i > 0; i--){
            graph[R-1][i-1] = temp[R-1][i];
        }

        //upMachine - down
        //(0,0)(1,0)(2,0)
        for(int i = 0; i < upMachine.x-1; i++){
            graph[i + 1][0] = temp[i][0];
        }
        //downMachine - up
        //(6,0)(5,0)(4,0)
        for(int i = R-1; i > downMachine.x + 1; i--){
            graph[i-1][downMachine.y] = temp[i][downMachine.y];
        }
    }

    private static void spreadDust() {
        int[][] temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp[i] = graph[i].clone();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(graph[i][j] == 0) continue;
                bfs(new Node(i, j),temp);
            }
        }
    }

    private static void bfs(Node start,int[][] temp) {
        int all = temp[start.x][start.y];
        int spreadNum = all/5;
        int spreadSum = 0;

        for (int i = 0; i < 4; i++) {
            int nX = start.x + dx[i];
            int nY = start.y + dy[i];

            if( nX < 0 || nY < 0 || nX >= R || nY >= C) continue;
            if(nX == airCondition.get(0).x && nY == airCondition.get(0).y) continue;
            if(nX == airCondition.get(1).x && nY == airCondition.get(1).y) continue;

            spreadSum += spreadNum;
            graph[nX][nY] += spreadNum;
        }

        graph[start.x][start.y] -= spreadSum;
    }

}

