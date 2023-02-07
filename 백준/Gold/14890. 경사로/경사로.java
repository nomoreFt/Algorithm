import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int N, L;
    static int[][] graph;

    private static boolean checkRoad(int[] line) {
        boolean[] checkBridge = new boolean[N];
        for (int i = 1; i < N; i++) {
            if (line[i - 1] != line[i]) {
                //경사로 차이가 1이 아닌 경우
                if (Math.abs(line[i - 1] - line[i]) != 1) {
                    return false;
                }
                //올라가야 하는 경우
                if (line[i - 1] < line[i]) {
                    //범위를 벗어나는 경우
                    int now = i;
                    if (now - L < 0) return false;
                    //낮은 지점의 숫자가 연속으로 같은 숫자가 아니고 L개가 연속되지 않는 경우
                    for (int j = 1; j <= L; j++) {
                        if (line[i - 1] != line[i - j]) return false;
                        if (checkBridge[i - j]) return false;
                        //이미 놓 은데 또 놓는 경우
                    }

                    //다리를 놓음
                    for (int j = 1; j <= L; j++) {
                        checkBridge[i - j] = true;
                    }
                } else { //내려가야 하는 경우
                    //범위를 벗어나는 경우
                    int now = i - 1;
                    if (now + L >= N) return false;

                    for (int j = 0; j < L; j++) {
                        if (line[i] != line[i + j]) return false;//낮은 지점의 칸이 같지 않을 떄
                        if (checkBridge[i + j]) return false;
                    }

                    for (int j = 0; j < L; j++) {
                        checkBridge[i + j] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {//가로
            int[] line = new int[N];

            for (int j = 0; j < N; j++) {
                line[j] = graph[i][j];
            }

            if (checkRoad(line)) ans++;

        }

        for (int j = 0; j < N; j++) {
            int[] line = new int[N];

            for (int i = 0; i < N; i++) {
                line[i] = graph[i][j];
            }

            if (checkRoad(line)) ans++;
        }
        System.out.println(ans);
    }
}