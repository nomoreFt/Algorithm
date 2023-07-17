import java.io.*;
import java.util.*;

class Term{
    int num;
    int op;

    public Term(int num, int op) {
        this.num = num;
        this.op = op;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Term[] a = new Term[n];

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a[i] = new Term(s.charAt(i) - '0', 0);
            } else {
                int op = 1;
                if (s.charAt(i) == '-') {
                    op = 2;
                } else if (s.charAt(i) == '*') {
                    op = 3;
                }
                a[i] = new Term(0, op);
            }
        }

        int m = (n - 1) / 2;

        for (int bit = 0; bit < (1 << m); bit++) {
            boolean ok = true;

            for(int i = 0; i < m - 1; i++) {
                if((bit & (1 << i)) > 0 && (bit & (1 << (i + 1))) > 0) {
                    ok = false;
                    break;
                }
            }
            if(!ok) continue;

            Term[] b = new Term[n];

            for (int j = 0; j < n; j++) {
                b[j] = new Term(a[j].num, a[j].op);
            }
            for (int j = 0; j < m; j++) {
                if ((bit & (1 << j)) > 0) {
                    int k = 2 * j + 1;
                    if (b[k].op == 1) {
                        b[k-1].num += b[k+1].num;
                        b[k+1].num = 0;
                    } else if (b[k].op == 2) {
                        b[k-1].num -= b[k+1].num;
                        b[k].op = 1;
                        b[k+1].num = 0;
                    } else if (b[k].op == 3) {
                        b[k-1].num *= b[k+1].num;
                        b[k].op = 1;
                        b[k+1].num = 0;
                    }
                }
            }

            int res = b[0].num;

            for (int j = 0; j < m; j++) {
                int k = 2*j+1;
                if (b[k].op == 1) {
                    res += b[k+1].num;
                } else if (b[k].op == 2) {
                    res -= b[k+1].num;
                } else if (b[k].op == 3) {
                    res *= b[k+1].num;
                }
            }

            if(ans < res) ans = res;
        }

        System.out.println(ans);
    }
}


