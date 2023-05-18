import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Shark{
        int speed;
        int dir;
        int size;
        public Shark(int speed, int dir, int size){
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

    }
    static int R, C, M;
    static Shark[][] graph;
    static int[] dx = {-1, 1, 0, 0}; // 위, 아래, 오른쪽, 왼쪽
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]); // 행
        C = Integer.parseInt(input[1]); // 열
        M = Integer.parseInt(input[2]); // 상어의 수

        graph = new Shark[R][C];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]) - 1;
            int c = Integer.parseInt(input[1]) - 1;
            int s = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]) - 1;
            int z = Integer.parseInt(input[4]);
            graph[r][c] = new Shark(s, d, z);
        }

        int ans = 0;
        //낚시왕 이동
        for (int t = 0; t < C; t++) {
            //상어 잡기
            ans += getShark(t);
            moveShark();
        }

        System.out.println(ans);
    }

    private static void move(int x, int y, Shark now, Shark[][] newGraph) {
        for (int i = 0; i < now.speed; i++) {
            if (now.dir == 0) {//위
                if(x == 0) {
                    now.dir = 1;
                    x = 1;
                }else{
                    x--;
                }
            } else if (now.dir == 1) {//아래
                if (x == R - 1) {
                    now.dir = 0;
                    x = R - 2;
                }else{
                    x++;
                }
            } else if (now.dir == 2) {//오른쪽
                if (y == C - 1) {
                    now.dir = 3;
                    y  = C - 2;
                }else{
                    y++;
                }
            }else{//왼쪽
                if (y == 0) {
                    now.dir = 2;
                    y = 1;
                }else{
                    y--;
                }
            }
        }
        if (newGraph[x][y] == null || newGraph[x][y].size < now.size) {
            newGraph[x][y] = now;
        }
    }

    private static void moveShark() {
        Shark[][] newGraph = new Shark[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] != null) {
                    move(i,j,graph[i][j], newGraph);
                }
            }
        }

        graph = newGraph;
    }

    private static int getShark(int t) {
        int size = 0;
        for (int i = 0; i < R; i++) {
            if (graph[i][t] != null) {
                size += graph[i][t].size;
                graph[i][t] = null;
                return size;
            }
        }
        return 0;
    }

}

