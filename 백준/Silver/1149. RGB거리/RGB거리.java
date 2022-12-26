import java.io.*;

class Main {
    static int R = 0,G = 1, B = 2;
    static int[][] D;
    static int[][] A;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1][3];
        A = new int[N + 1][3];

        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            A[i + 1][R] = Integer.parseInt(strs[R]);
            A[i + 1][G] = Integer.parseInt(strs[G]);
            A[i + 1][B] = Integer.parseInt(strs[B]);
        }
        D[1][R] = A[1][R];
        D[1][G] = A[1][G];
        D[1][B] = A[1][B];

        for (int i = 2; i <= N; i++) {
            for (int color = 0; color <= 2; color++) {
                if (color == R) {
                    D[i][color] = Math.min(D[i - 1][G], D[i - 1][B]) + A[i][R];
                }
                if (color == G) {
                    D[i][color] = Math.min(D[i - 1][R], D[i - 1][B]) + A[i][G];
                }
                if (color == B) {
                    D[i][color] = Math.min(D[i - 1][R], D[i - 1][G]) + A[i][B];
                }
            }
        }
        System.out.println(Math.min(Math.min(D[N][R], D[N][G]), D[N][B]));
    }
}