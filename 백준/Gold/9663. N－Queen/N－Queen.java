import java.io.*;
import java.util.*;


class Main {
    static int N;
    static boolean[] colVisited;
    static boolean[] rightUpVisited;
    static boolean[] leftUpVisited;
    static int ans = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        colVisited = new boolean[N];
        rightUpVisited = new boolean[N + N];
        leftUpVisited = new boolean[N + N];


        //ㅡ
        setQueenRow(0);
        System.out.println(ans);
    }

    private static void setQueenRow(int row) {
        //마지막까지 내려갔단 소리
        if (row == N) {
            ans++;
        }

        // |
        for (int col = 0; col < N; col++) {
            if (canSetQueen(row, col)) {
                colVisited[col] = true;
                // /
                rightUpVisited[row+col] = true;
                // \
                leftUpVisited[N+row-col] = true;
                setQueenRow(row+1);
                colVisited[col] = false;
                // /
                rightUpVisited[row+col] = false;
                // \
                leftUpVisited[N+row-col] = false;
            }
        }

    }

    private static boolean canSetQueen(int row, int col) {
        if(colVisited[col]) return false;
        if(rightUpVisited[row+col]) return false;
        if(leftUpVisited[N+row-col]) return false;
        return true;
    }

}
