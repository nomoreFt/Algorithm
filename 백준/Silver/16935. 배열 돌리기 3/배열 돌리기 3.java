import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int n,m,r;
    static int[][] graph;

    static int[][] first(int[][] A) {
        n = A.length;
        m = A[0].length;
        int[][] B = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                B[i][j] = A[n - 1 - i][j];
            }
        }
        return B;
    }

    static int[][] second(int[][] A) {
        n = A.length;
        m = A[0].length;
        int[][] B = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                B[i][j] = A[i][m - 1 - j];
            }
        }

        return B;
    }
    static int[][] third(int[][] A) {
        n = A.length;
        m = A[0].length;
        int[][] B = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[n-j-1][i];
            }
        }

        return B;
    }
    static int[][] forth(int[][] A) {
        n = A.length;
        m = A[0].length;
        int[][] B = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[j][m - 1 - i];
            }
        }
        return B;
    }

    static int[][] fifth(int[][] A) {
        n = A.length;
        m = A[0].length;
        int[][] B = new int[n][m];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                B[i][j + m / 2] = A[i][j];
                B[i + n / 2][j + m / 2] = A[i][j + m / 2];
                B[i + n / 2][j] = A[i + n / 2][j + m / 2];
                B[i][j] = A[i + n / 2][j];
            }
        }
        return B;
    }
    static int[][] sixth(int[][] A) {
        n = A.length;
        m = A[0].length;
        int[][] B = new int[n][m];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                B[i + n/2][j] = A[i][j];
                B[i][j] = A[i][j + m / 2];
                B[i][j + m / 2] = A[i + n / 2][j + m / 2];
                B[i+n/2][j+m/2] = A[i+n/2][j];
            }
        }
        return B;
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        r = Integer.parseInt(strs[2]);

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(strs[j]);
            }
        }

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] B = graph;


        for (int a : arr) {
            if (a == 1) {
                B = first(B);
            }
            if (a == 2) {
                B = second(B);
            }
            if (a == 3) {
                B = third(B);
            }
            if (a == 4) {
                B = forth(B);
            }
            if (a == 5) {
                B = fifth(B);
            }
            if (a == 6) {
                B = sixth(B);
            }
        }

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                System.out.print(B[i][j]+" ");
            }
            System.out.println();
        }

    }
}