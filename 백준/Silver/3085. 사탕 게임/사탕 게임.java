import java.io.*;
import java.util.Arrays;

class Main {
    static int N;
    static char[][] graph;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //가로 교환
                if (j + 1 < N) {
                    //SWAP
                    char now = graph[i][j];
                    graph[i][j] = graph[i][j + 1];
                    graph[i][j+1] = now;

                    checkMax(i, i, j, j + 1);
                    //원상복구
                    now = graph[i][j];
                    graph[i][j] = graph[i][j + 1];
                    graph[i][j+1] = now;
                }
                if (i + 1 < N) {
                    //SWAP
                    char now = graph[i][j];
                    graph[i][j] = graph[i+1][j];
                    graph[i+1][j] = now;

                    checkMax(i, i+1, j, j);
                    //원상복구
                    now = graph[i][j];
                    graph[i][j] = graph[i+1][j];
                    graph[i+1][j] = now;
                }
            }
        }

        System.out.println(result);
    }

    private static void checkMax(int startRow, int endRow, int startCol, int endCol) {
        //가로 체크
        for (int i = startRow; i <= endRow; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                char now = graph[i][j];
                if (now == graph[i][j + 1]) {
                    cnt++;
                }else{
                    cnt = 1;
                }
                result = Math.max(result,cnt);
            }
        }

        for (int i = startCol; i <= endCol; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                char now = graph[j][i];
                if (now == graph[j+1][i]) {
                    cnt++;
                }else{
                    cnt = 1;
                }
                result = Math.max(result,cnt);
            }
        }
    }
}



