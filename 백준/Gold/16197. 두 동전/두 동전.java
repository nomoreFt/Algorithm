import java.io.*;
import java.util.*;


class Main {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans = -1;
    static char[][] graph;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new char[N][M];

        int x1,y1,x2,y2;
        x1=x2=y1=y2=-1;

        for (int i = 0; i < N; i++) {
            graph[i] = sc.next().toCharArray();
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 'o') {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    }else{
                        x2 = i;
                        y2 = j;
                    }
                    graph[i][j] = '.';
                }
            }
        }
        go(0, x1, y1, x2, y2);
        System.out.println(ans);

    }
    public static void go(int step,int x1,int y1, int x2, int y2) {
        if (step > 10) {
            
            return;
        }

        boolean fall1 = false;
        boolean fall2 = false;
        if(x1 < 0 || N<=x1 || y1 < 0 || M <= y1 ) fall1 = true;
        if(x2 < 0 || N<=x2 || y2 < 0 || M <= y2 ) fall2 = true;
        if(fall1 && fall2) return;
        if(fall1 || fall2) {
            if (ans == -1) {
                ans = step;
            }else{
                ans = Math.min(ans, step);
            }

        }

        for (int k = 0; k < 4; k++) {
            int nx1 = x1 + dx[k];
            int ny1 = y1 + dy[k];
            int nx2 = x2 + dx[k];
            int ny2 = y2 + dy[k];

            if (0 <= nx1 && nx1 < N && 0 <= ny1 && ny1 < M && graph[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }
            if (0 <= nx2 && nx2 < N && 0 <= ny2 && ny2 < M && graph[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }

            go(step + 1, nx1, ny1, nx2, ny2);
        }
    }
}
