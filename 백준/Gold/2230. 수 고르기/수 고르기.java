import java.io.*;
import java.util.*;

class Main {
    static int N,M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(Integer.valueOf(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());


        int left = 0;
        int right = 0;
        while(right < N){
            int diff = list.get(right) - list.get(left);
            if(diff == M){
                min = M;
                break;
            }
            if(diff < M){
                right++;
            }else{
                min = Math.min(min,diff);
                left++;
            }
        }
        
       System.out.println(min);
    }
}