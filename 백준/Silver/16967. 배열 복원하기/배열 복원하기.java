import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int H,W,X,Y;
    static int[][] B;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        H = Integer.parseInt(strs[0]);
        W = Integer.parseInt(strs[1]);
        X = Integer.parseInt(strs[2]);
        Y = Integer.parseInt(strs[3]);

        B = new int[H+X][W+Y];
        for (int i = 0; i < H + X; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(strs[j]);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                B[i + X][j + Y] -= B[i][j];
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(B[i][j]+" ");
            }
            System.out.println();
        }
    }
}