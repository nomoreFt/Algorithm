import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    static int N;
    static int[][] S;
    static ArrayList<Integer> start = new ArrayList<>();
    static ArrayList<Integer> link = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(strs[j]);
            }
        }
        dfs(0, start, link);
        System.out.println(result);
    }

    public static void dfs(int idx, ArrayList<Integer> start, ArrayList<Integer> link) {
        if (idx == N) {
            if(start.size() != N/2) return;
            if(link.size() != N/2) return;
            int startScore = 0;
            int linkScore = 0;
            for (int i = 0; i < start.size(); i++) {
                for (int j = 0; j < start.size(); j++) {
                    startScore += S[start.get(i)][start.get(j)];
                }
            }
            for (int i = 0; i < link.size(); i++) {
                for (int j = 0; j < link.size(); j++) {
                    linkScore += S[link.get(i)][link.get(j)];
                }
            }
            result = Math.min(result,Math.abs(startScore - linkScore));
            return;
        }
        if(idx > N) return;
        start.add(idx);
        dfs(idx + 1, start, link);
        start.remove(start.size()-1);
        link.add(idx);
        dfs(idx + 1, start, link);
        link.remove(link.size()-1);
    }
}