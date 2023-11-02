import java.io.*;
import java.security.Principal;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]  = sc.nextInt();
        }
        operator[0] = sc.nextInt();
        operator[1] = sc.nextInt();
        operator[2] = sc.nextInt();
        operator[3] = sc.nextInt();

        go(1,arr[0], operator);

        System.out.println(max);
        System.out.println(min);

    }


    public static void go(int nowIdx, int result, int[] operator){
        if(nowIdx == N){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        if(operator[0] > 0){
            operator[0]--;
            go(nowIdx + 1, result + arr[nowIdx], operator);
            operator[0]++;
        }

        if(operator[1] > 0){
            operator[1]--;
            go(nowIdx + 1, result - arr[nowIdx], operator);
            operator[1]++;
        }

        if(operator[2] > 0){
            operator[2]--;
            go(nowIdx + 1, result * arr[nowIdx], operator);
            operator[2]++;
        }

        if(operator[3] > 0){
            operator[3]--;
            go(nowIdx + 1, result / arr[nowIdx], operator);
            operator[3]++;
        }

    }


}