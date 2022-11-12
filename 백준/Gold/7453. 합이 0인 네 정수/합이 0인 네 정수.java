import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int[] A,B,C,D;
    static int[] preSumA,preSumB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                int temp = Integer.parseInt(s[j]);
                if(j==0) A[i] = temp;
                else if(j==1) B[i] = temp;
                else if(j==2) C[i] = temp;
                else D[i] = temp;
            }
        }

        preSumA = new int[N * N];
        preSumB = new int[N * N];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                preSumA[count] = A[i] + B[j];
                preSumB[count++] = C[i] + D[j];
            }
        }
        Arrays.sort(preSumA);
        Arrays.sort(preSumB);

        int aSize = preSumA.length;
        int bSize = preSumB.length;

        long cnt = 0;
        int leftPointer = 0;
        int rightPointer = bSize - 1;

        while(leftPointer < aSize && rightPointer >= 0){
            int sum = preSumA[leftPointer] + preSumB[rightPointer];
            if(sum == 0){

                int a = preSumA[leftPointer];
                int b = preSumB[rightPointer];
                long leftCnt = 0;
                long rightCnt = 0;

                while(leftPointer < aSize && preSumA[leftPointer] == a){
                    leftCnt++;
                    leftPointer++;
                }
                while(rightPointer >= 0 && preSumB[rightPointer] == b){
                    rightPointer--;
                    rightCnt++;
                }
                cnt += leftCnt * rightCnt;
                }
            else if(sum < 0) leftPointer++;
            else if(sum > 0) rightPointer--;

            }
        System.out.println(cnt);
    }
}