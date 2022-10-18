import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr.add(2);
        for (int i = 3; i <= N; i++) {
            isPrime(i);
        }
        int arrSize = arr.size();
        int left = 0,right = 0,sum = 0,cnt =0;
        while (true) {
            if (sum >= N) {
                sum -= arr.get(left++);
            }else if(right == arrSize) break;
            else{
                sum += arr.get(right++);
            }
            if (sum == N) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return;
            }
        }
        arr.add(x);
    }
}