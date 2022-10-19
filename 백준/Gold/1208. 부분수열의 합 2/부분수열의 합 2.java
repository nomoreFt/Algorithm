import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int S = Integer.parseInt(strs[1]);

         arr = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> left = new ArrayList<>();
        getSumList(0, N / 2, 0, left);
        ArrayList<Integer> right = new ArrayList<>();
        getSumList(N / 2, N, 0, right);

        left.sort(Comparator.reverseOrder());
        right.sort(Comparator.naturalOrder());

        int leftPointer =0, rightPointer = 0;

        long cnt = 0l;
        while (leftPointer < left.size() && rightPointer < right.size()) {
            int leftSum = left.get(leftPointer);
            int rightSum = right.get(rightPointer);

            int sum = leftSum + rightSum;
            if (sum > S) {
                leftPointer++;
                continue;
            }
            if (sum < S) {
                rightPointer++;
                continue;
            }
            if (sum == S) {
                long leftCnt = 0l, rightCnt = 0l;
                while (rightPointer < right.size() && leftSum + right.get(rightPointer) == S) {
                    rightPointer++;
                    rightCnt++;
                }
                while(leftPointer < left.size() && rightSum + left.get(leftPointer)==S){
                    leftPointer++;
                    leftCnt++;
                }
                cnt += leftCnt * rightCnt;
            }
        }
        if(S == 0) cnt--;
        System.out.println(cnt);
    }

    public static void getSumList(int idx, int end, int accum, List<Integer> left) {
        if (idx == end) {
            left.add(accum);
            return;
        }
        getSumList(idx + 1, end, accum, left);
        getSumList(idx + 1, end, accum+arr[idx], left);
    }
}