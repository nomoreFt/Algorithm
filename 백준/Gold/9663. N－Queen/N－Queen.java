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
        //depth +1 될 때 마다 왼쪽에서 오른쪽으로 진행이다. 전체 진행 완료란 의미
        if (depth == N) {
            result++;
            return;
        }
        //depth (열) 별로 한 줄씩 체스를 둘 수 있는지 check
        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (Possibility(depth)) {
                nQueen(depth +1);
            }
        }
    }

    static boolean Possibility(int depth) {
        //현재 세로줄에서 놓을 수 있는 위치를 확인해야 하니까
        //그 이전 줄들까지 두었던 체스말들 (arr[0~depth-1] 값들)과 가로줄, 대각선 비교
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i]) {//이전 체스말들 (arr[i]과 지금 둘 수 있는지 확인하는 위치가 가로줄이 맞으면 못둠
                return false;
                
            }else if(//내가 두고자 하는 위치와 이전에 두어졌던 체스말들과 가로행, 세로행의 차 절대값이 같으면 대각선
                    Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) return false;
        }
        return true;
    }
}

