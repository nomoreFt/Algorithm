import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int T, N, M;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                first.add(sum);
            }
        }
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                second.add(sum);
            }
        }


        Collections.sort(first);
        Collections.sort(second);

        int firstSize = first.size();
        int secondSize = second.size();
        long ans = 0;
        int left = 0;
        int right = second.size()-1;

        while (left < firstSize && right >= 0) {
            int sum = first.get(left) + second.get(right);
            if (sum== T) {
                int a = first.get(left);
                int b = second.get(right);
                long c1 = 0;
                long c2 = 0;
                while (left < firstSize && first.get(left) == a) {
                    c1++;
                    left++;
                }
                while (right >=0 && second.get(right) == b) {
                    c2++;
                    right--;
                }

                ans += c1 * c2;
            } else if (sum < T) {
                left++;
            }else if(sum > T){
                right--;
            }
        }

        System.out.println(ans);

    }
}