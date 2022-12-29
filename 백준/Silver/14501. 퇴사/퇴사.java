import java.io.*;
import java.util.Arrays;

class Main {
    static int N;
    static int[] T,P;
    static int maxPrice = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] strs = br.readLine().split(" ");
            T[i] = Integer.parseInt(strs[0]);
            P[i] = Integer.parseInt(strs[1]);
        }
        //변하는것 날짜, 총합
        dfs(1, 0);
        System.out.println(maxPrice);
    }

    static void dfs(int day, int sum) {
        if (day == N + 1) {
            maxPrice = Math.max(sum, maxPrice);
            return;
        }
        if(day > N+1) return;
        //선택X
        dfs(day + 1, sum);
        dfs(day + T[day], sum + P[day]);

    }

}



