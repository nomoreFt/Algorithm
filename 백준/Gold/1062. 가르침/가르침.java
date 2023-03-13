import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N,K;
    static int[] arr;
    static boolean[] alpha = new boolean[26];
    static String[] words;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        K = Integer.parseInt(strs[1]);
        words = new String[N];
        alpha['a'-'a'] = alpha['n'-'a'] = alpha['t'-'a'] = alpha['i'-'a'] = alpha['c'-'a'] = true;

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            words[i] = words[i].substring(4, words[i].length()-4);
        }

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }


            go(0, 5);
        System.out.println(MAX);
    }

    private static void go(int idx, int choice) {
        if (choice == K) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!alpha[words[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }
            MAX = Math.max(MAX, cnt);
            return;
        }
        for(int i = idx; i < 26; i++) {
            if(!alpha[i]) {
                alpha[i] = true;
                go(i, choice+1);
                alpha[i] = false;
            }
        }
    }
}