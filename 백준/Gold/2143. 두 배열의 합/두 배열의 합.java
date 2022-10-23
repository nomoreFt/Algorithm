import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

class Main {
    static int[] A,B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        A = stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        B = stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> accumA = new ArrayList<>();
        ArrayList<Integer> accumB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += A[j];
                accumA.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                accumB.add(sum);
            }
        }
        Collections.sort(accumA);
        Collections.sort(accumB);

        int aSize = accumA.size();
        int bSize = accumB.size();

        long cnt = 0;
        int leftPointer = 0;
        int rightPointer = accumB.size() - 1;

        while (leftPointer < aSize && rightPointer >= 0) {
            int sum = accumA.get(leftPointer) + accumB.get(rightPointer);
            if (sum == T) {

                int a = accumA.get(leftPointer);
                int b = accumB.get(rightPointer);
                long leftCnt = 0;
                long rightCnt = 0;

                while(leftPointer < aSize && accumA.get(leftPointer) == a){
                    leftCnt++;
                    leftPointer++;
                }
                while(rightPointer >= 0 && accumB.get(rightPointer) == b){
                    rightCnt++;
                    rightPointer--;
                }
                cnt += leftCnt * rightCnt;
            } else if (sum < T) {
                leftPointer++;
            } else if (sum > T) {
                rightPointer--;
            }
        }


        System.out.println(cnt);


    }

}