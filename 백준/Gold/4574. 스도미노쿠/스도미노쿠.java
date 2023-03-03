import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

class Main {
    static int[][] a = new int[10][10];
    static boolean[][] c = new boolean[10][10];
    static boolean[][] c2 = new boolean[10][10];
    static boolean[][] c3 = new boolean[10][10];
    static boolean[][] domino = new boolean[10][10];
    static final int n = 9;
    static final int[] dx = {0, 1};
    static final int[] dy = {1, 0};
    static int square(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }
    static boolean can(int x, int y, int num) {
        return c[x][num] == false && c2[y][num] == false && c3[square(x,y)][num] == false;
    }
    static boolean check_range(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    static int cnt = 0;

    static void go(int z) {
        if (z == 81 && cnt == 0) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
            cnt++;
            return;
        }
        int x = z/n;
        int y = z%n;
        if (a[x][y] != 0) {
             go(z + 1);
        } else{
            for (int k = 0; k < 2; k++) {
                int nX = x + dx[k];
                int nY = y + dy[k];

                if(nX < 0 || nX >= 9 || nY < 0 || nY >= 9) continue;
                if(a[nX][nY] != 0) continue;

                for (int i = 1; i <= 9; i++) {
                    for (int j = 1; j <= 9; j++) {
                        if(i==j) continue;
                        if(domino[i][j]) continue;
                        if(can(x,y,i) && can(nX,nY,j)) {
                            check(x,y,i,true);
                            check(nX,nY,j,true);
                            domino[i][j] = true;
                            a[x][y] = i;
                            a[nX][nY] = j;
                            go(z+1);
                            a[x][y] = 0;
                            a[nX][nY] = 0;
                            domino[i][j] = false;
                            check(x,y,i,false);
                            check(nX,nY,j,false);
                        }
                    }
                }
            }
        }
    }
    static void check(int x, int y, int num, boolean what) {
        c[x][num] = what;
        c2[y][num] = what;
        c3[square(x,y)][num] = what;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while (true) {
            for (int i = 0; i < 10; i++) {
                Arrays.fill(c[i], false);
                Arrays.fill(c2[i], false);
                Arrays.fill(c3[i], false);
                Arrays.fill(domino[i], false);
                Arrays.fill(a[i], 0);
            }
            int m = sc.nextInt();
            if (m == 0) break;
            for (int i = 0; i < m; i++) {
                int n1 = sc.nextInt();
                String s1 = sc.next();
                int n2 = sc.nextInt();
                String s2 = sc.next();
                int x1 = s1.charAt(0) - 'A';
                int y1 = s1.charAt(1) - '1';
                int x2 = s2.charAt(0) - 'A';
                int y2 = s2.charAt(1) - '1';
                a[x1][y1] = n1;
                a[x2][y2] = n2;
                domino[n1][n2] = domino[n2][n1] = true;
                check(x1, y1, n1, true);
                check(x2, y2, n2, true);
            }
            for (int i = 1; i <= 9; i++) {
                String s = sc.next();
                int x = s.charAt(0) - 'A';
                int y = s.charAt(1) - '1';
                a[x][y] = i;
                check(x, y, i, true);
            }
            System.out.println("Puzzle " + tc);
            go(0);
            cnt = 0;
            tc += 1;
        }
    }
}

