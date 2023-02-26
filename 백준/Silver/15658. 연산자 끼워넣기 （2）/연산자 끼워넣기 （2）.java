import java.io.*;
import java.util.*;


class Main {
    static int  N;
    static int[] A;
    static int[] B = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;




    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            B[i] = sc.nextInt();
        }

        dfs(0,B[0],B[1],B[2],B[3],"");
        System.out.println(MAX);
        System.out.println(MIN);


    }

    public static void dfs(int idx,int plus, int minus, int mul,int div, String str) {
        if(idx == N-1){
            String[] split = str.split("");
            int sum = A[0];
            for (int i = 0; i < split.length; i++) {
                if (Integer.parseInt(split[i]) == 0) {
                    sum += A[i + 1];
                }
                if (Integer.parseInt(split[i]) == 1) {
                    sum -= A[i + 1];
                }
                if (Integer.parseInt(split[i]) == 2) {
                    sum *= A[i + 1];
                }
                if (Integer.parseInt(split[i]) == 3) {
                    sum /= A[i + 1];
                }
            }
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }

        if (plus > 0) {
            dfs(idx + 1, plus - 1, minus, mul, div,str+"0");
        }
        if (minus > 0) {
            dfs(idx + 1, plus, minus -1, mul, div, str+"1");
        }
        if (mul > 0) {
            dfs(idx + 1, plus, minus, mul-1, div, str+"2");
        }
        if (div > 0) {
            dfs(idx + 1, plus, minus, mul, div-1, str+"3");
        }

    }

}