import java.io.*;
import java.util.*;


class Main {
    static int N = 9;
    static int[][] graph = new int[9][9];
    static int[] sdoku = new int[81];
    static boolean[][] c = new boolean[9][10];// ㅡ
    static boolean[][] c2 = new boolean[9][10];// |
    static boolean[][] c3 = new boolean[9][10];// ㅁ

    static int zeroCnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(strs[j]);
                graph[i][j] = temp;
                if (temp != 0) {
                    c[i][temp] = true;
                    c2[j][temp] = true;
                    c3[square(i,j)][temp] = true;
                }else{
                    zeroCnt++;
                }
            }
        }
        calc(0);
    }

    private static int square(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }

    private static void calc(int z) {
        if (z == 81) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);

        }
        int x = z/N;
        int y = z%N;
        if (graph[x][y] != 0) {
            calc(z + 1);
        }else{
            for (int i = 1; i <= 9; i++) {
                if (!c[x][i] && !c2[y][i] && !c3[square(x, y)][i]) {
                    c[x][i] =c2[y][i] =c3[square(x, y)][i] = true;
                    graph[x][y] = i;
                    calc(z + 1);
                    graph[x][y] = 0;
                    c[x][i] =c2[y][i] =c3[square(x, y)][i] = false;
                }
            }
        }
    }

    private static boolean check(int x, int y, int value) {
        if(c[x][value]) return false;
        if(c2[y][value]) return false;
        if(c3[square(x,y)][value]) return false;
        return true;
    }

}
