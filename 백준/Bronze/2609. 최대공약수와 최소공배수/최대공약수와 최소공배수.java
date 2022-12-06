import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringBuilder sb = new StringBuilder();
        sb.append(GCD(arr[0], arr[1])+"\n");
        sb.append(LCD(arr[0], arr[1]));

        System.out.println(sb.toString());

    }


//    1. 최대 공약수 (유클리드 호제법)

    /**
     * 서로 가진 수들을 다 빼고 한 쪽이 남은게 0이면 최대 공약수 (승자)
     */
    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    //2. 최소 공배수

    /**
     *양 쪽의 최대공약수로 잇는 숫자 다 털게 나눈다음, 그 두개를 곱한것에서
     * 최대공약수를 곱해준다.
     */
    static int LCD(int a, int b) {
        int gcd = GCD(a, b);
        return gcd * (a / gcd) * (b / gcd);
    }

}



