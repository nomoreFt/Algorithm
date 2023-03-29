
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int a,b,c;
    static int sum;
    static boolean[][] visited = new boolean[1501][1501];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        sum = a+b+c;
        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }
        dfs(a, b);

        if (visited[sum / 3][sum / 3]) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }


    }

    private static void dfs(int x, int y) {
        if(visited[x][y]) return;
        visited[x][y] = true;
        int[] a = {x, y, sum - x - y};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i] < a[j]) {
                    int[] b = {x, y, sum - x - y};
                    b[i] = a[i]*2;
                    b[j] -= a[i];
                    dfs(b[0], b[1]);
                }
            }
        }
    }
}