import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += (n/i) * i;
            /*
            (n/i) = 1~n까지 숫자중에 i를 약수로 갖는 수의 개수가 구해진다.
            ex ) 1, 2, 3, 4, 5, 6, 7 이면, 2를 약수로 갖는 수의 개수는 2,4,6 = 7/2 = 3
             */
        }
        System.out.println(result);
    }
}