import java.io.*;
import java.sql.Array;
import java.time.chrono.MinguoChronology;
import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(result);
    }
    //arr[depth열] = 값(행) ex) arr[0] = 1  (0,1)에 체스가 위치
    static void nQueen(int depth) {
        //depth -> 왼쪽에서 오른쪽인데
        if (depth == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (Possibility(depth)) {
                nQueen(depth +1);
            }
        }
    }

    static boolean Possibility(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i]) {
                return false;
            }else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) return false;
        }
        return true;
    }
}

