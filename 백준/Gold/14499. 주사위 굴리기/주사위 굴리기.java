import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int n,m,x,y,orderCnt;
    static int[][] a;
    static int orderArr[];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        x = Integer.parseInt(strs[2]);
        y = Integer.parseInt(strs[3]);
        orderCnt = Integer.parseInt(strs[4]);

        a = new int[n][m];

        int[] dice = new int[7];
        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(strs[j]);
            }
        }

        orderArr = new int[orderCnt];
        strs = br.readLine().split(" ");
        for (int i = 0; i < orderCnt; i++) {
            orderArr[i] = Integer.parseInt(strs[i]);
        }

        for (int k : orderArr) {
            k = k-1;
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                // 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 함, 출력도 하면 안됨
                continue;
            }
            if (k == 0) { // right
                int temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
            } else if (k == 1) { // left
                int temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
            } else if (k == 2) { // up
                int temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
            } else { // down
                int temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
            }
            x = nx;
            y = ny;
            if (a[x][y] == 0) {
                // 주사위를 굴렸을 때, 이동한 칸에 써 있는 수가 0이면, 주사위의 바닥면에 써 있는 수가 칸에 복사됨
                a[x][y] = dice[6];
            } else {
                // 0이 아닌 경우에는 칸에 써 있는 수가 주사위의 바닥면으로 복사되며,
                dice[6] = a[x][y];
                // 칸에 써 있는 수는 0이 복사됨
                a[x][y] = 0;
            }
            System.out.println(dice[1]);
        }
    }
}





