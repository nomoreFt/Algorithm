import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int result = 0;
    static int L,C;
    static String[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        L = Integer.parseInt(strs[0]);
        C = Integer.parseInt(strs[1]);

        alpha = br.readLine().split(" ");
        Arrays.sort(alpha);

        dfs(0,0,"");

    }

    static void dfs(int idx,int depth,String result){
        if (depth == L && checkPossible(result)) {
            System.out.println(result);
            return;
        }
        if(idx >= alpha.length) return;
        dfs(idx+1, depth + 1, result + alpha[idx]);
        dfs(idx+1, depth, result);

    }

    private static boolean checkPossible(String result) {
        char[] vowels = {'a','e','i','o','u'};
        int vowelCnt = 0;

        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            for (char x : vowels) {
                if(c == x) vowelCnt++;
            }
        }

        if(vowelCnt == 0) return false;
        if(vowelCnt >= L-1) return false;
        return true;
    }
}



