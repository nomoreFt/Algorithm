import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static String[][] graph;
    static int N;
    static int ans = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = strs[j];
            }
        }
        //오른쪽 아래 swap
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //오른쪽
                if (j + 1 < N) {
                    swapRow(i, j);
                    checkCandy(i, i, j, j + 1);
                    swapRow(i, j);
                }
                //아래
                if (i + 1 < N) {
                    swapCol(i, j);
                    checkCandy(i, i+1, j, j);
                    swapCol(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    private static void checkCandy(int startRow, int endRow, int startCol, int endCol) {
        //가로 체크
        for (int i = startRow; i <= endRow; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                if (graph[i][j].equals(graph[i][j + 1])) {
                    cnt+=1;
                }else{
                    cnt=1;
                }
                ans = Math.max(ans, cnt);
            }
        }
        //세로 체크
        for (int i = startCol; i <= endCol; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (graph[j][i].equals(graph[j + 1][i])) {
                    cnt+=1;
                }else{
                    cnt=1;
                }
                ans = Math.max(ans, cnt);
            }
        }
    }

    private static void swapRow(int i, int j) {
        String now = graph[i][j];
        graph[i][j] = graph[i][j + 1];
        graph[i][j+1] = now;
    }
    private static void swapCol(int i, int j) {
        String now = graph[i][j];
        graph[i][j] = graph[i+1][j];
        graph[i+1][j] = now;
    }
}