import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int[] r = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {
            int r1 = r[i];
            int c1 = c[i];
            for (int j = i + 1; j < n; j++) {
                int r2 = r[j];
                int c2 = c[j];

                for (int rot1 = 0; rot1 < 2; rot1++) {
                    for (int rot2 = 0; rot2 < 2; rot2++) {
                        //가로로 붙인 경우
                        if (r1 + r2 <= h && Math.max(c1, c2) <= w) {
                            ans = Math.max(ans,r1*c1 + r2*c2);
                        }

                        //세로로 붙인 경우
                        if (Math.max(r1, r2) <= h && c1 + c2 <= w) {
                            ans = Math.max(ans,r1*c1 + r2*c2);
                        }

                        int t2 = r2;
                        r2 = c2;
                        c2 = t2;
                    }
                    int t1 = r1;
                    r1 = c1;
                    c1 = t1;
                }
            }
        }
        System.out.println(ans);
    }
}

