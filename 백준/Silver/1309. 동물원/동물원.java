import java.io.*;

class Main {
    static int none = 0,left = 1, right = 2;
    static int N;
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        N = Integer.parseInt(br.readLine());
        D = new int[N + 1][3];
        D[1][none] = 1;
        D[1][left] = 1;
        D[1][right] = 1;

        for (int i = 2; i <= N; i++) {
            for (int status = 0; status < 3; status++) {
                if (status == none) {
                    D[i][none] = ( D[i-1][left] + D[i-1][right] + D[i-1][none])%9901;
                }
                if (status == left) {
                    D[i][left] = (D[i-1][none] + D[i-1][right])%9901;
                }
                if (status == right) {
                    D[i][right] = (D[i-1][none] + D[i-1][left])%9901;
                }
            }
        }

        System.out.println((D[N][none]+D[N][left]+D[N][right])%9901);
    }
}
