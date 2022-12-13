import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static int result = 0;
    static int L,C;
    static String[] strs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        strs = br.readLine().split(" ");
        L = Integer.parseInt(strs[0]);
        C = Integer.parseInt(strs[1]);

        strs = br.readLine().split(" ");
        Arrays.sort(strs);

        dfs(0,0,"");

    }

    static void dfs(int start,int depth,String result){
        if (depth == L && checkPossible(result)) {
            System.out.println(result);
            return;
        }
        if(depth > L) return;
        for (int i = start; i < C; i++) {
            dfs(i+1, depth + 1, result + strs[i]);
        }
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



