import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static String[] strs;
    static boolean[] isTeached;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temps = br.readLine().split(" ");
        N = Integer.parseInt(temps[0]);
        K = Integer.parseInt(temps[1]);

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        strs = new String[N];
        isTeached = new boolean[26];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            strs[i] = temp.substring(4,temp.length()-4);
        }

        isTeached['a'-'a'] = true;
        isTeached['c' - 'a'] = true;
        isTeached['i' - 'a'] = true;
        isTeached['n' - 'a'] = true;
        isTeached['t' - 'a'] = true;

        dfs(5,0);
        System.out.println(result);
    }

    static void dfs(int depth, int idx) {
        if (depth == K) {
            check();
            return;
        }
        for (int i = idx; i < 26; i++) {
            if(!isTeached[i]){
                isTeached[i] = true;
                dfs(depth + 1, i);
                isTeached[i] = false;
            }
        }
    }

    private static void check() {

        int canReadStrCnt = 0;
        for (int i = 0; i < N; i++) {
            int strslen = strs[i].length();
            boolean canRead = true;
            for (int j = 0; j < strslen; j++) {
                if (!isTeached[strs[i].charAt(j) - 'a']) {
                   canRead = false;
                    break;
                }
            }
            if(canRead) canReadStrCnt++;
        }
        result = Math.max(result, canReadStrCnt);
    }
}
