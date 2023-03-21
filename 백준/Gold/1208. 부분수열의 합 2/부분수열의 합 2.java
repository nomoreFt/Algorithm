import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class Main {
    static int N, S;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        S = Integer.parseInt(strs[1]);

        temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = N/2;
        int n = N - m;


        int[] first = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int k = 0; k < n; k++) {
                if ((i & (1 << k)) != 0) {
                    first[i] += temp[k];
                }
            }
        }

        int[] second = new int[1 << m];
        for (int i = 0; i < (1 << m); i++) {
            for (int k = 0; k < m; k++) {
                if ((i & (1 << k)) != 0) {
                    second[i] += temp[k + n];
                }
            }
        }

        Arrays.sort(first);
        Arrays.sort(second);
        n = (1<<n);
        m = (1<<m);
        for (int i=0; i<m/2; i++) {
            int temp = second[i];
            second[i] = second[m-i-1];
            second[m-i-1] = temp;
        }
        int i = 0;
        int j = 0;
        long ans = 0;
        while (i < n && j < m) {
            if (first[i] + second[j] == S) {
                long c1 = 1;
                long c2 = 1;
                i += 1;
                j += 1;
                while (i < n && first[i] == first[i-1]) {
                    c1 += 1;
                    i += 1;
                }
                while (j < m && second[j] == second[j-1]) {
                    c2 += 1;
                    j += 1;
                }
                ans += c1*c2;
            } else if (first[i] + second[j] < S) {
                i += 1;
            } else {
                j += 1;
            }
        }
        if (S == 0) ans -= 1;

        System.out.println(ans);
    }
}