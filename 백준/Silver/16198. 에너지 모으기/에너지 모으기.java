import java.io.*;
import java.util.*;

class Main {

    static int N;
    static ArrayList<Integer> goos;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        goos = new ArrayList<>();
        String[] inputs = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            goos.add(Integer.parseInt(inputs[i]));
        }

        solution(0,goos);

        System.out.println(answer);

    }

    public static void solution(int sum,ArrayList<Integer> list) {
        int size = list.size();
        if(size == 2) {
            answer = Math.max(answer,sum);
            return;
        }

        for(int i = 1; i < size-1; i++) {
            int temp = list.get(i);
            int tempSum = list.get(i-1) * list.get(i+1);
            list.remove(i);
            solution(sum+tempSum,list);
            list.add(i,temp);
        }

    }
}