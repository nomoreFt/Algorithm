import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            strs = br.readLine().split(" ");
            checkCmd(strs);
        }
        System.out.println(sb.toString());
    }

    private static void checkCmd(String[] strs) {
        if(strs[0].equals("push")){
         deque.offer(Integer.parseInt(strs[1]));
        }else if(strs[0].equals("pop")){
            sb.append(deque.isEmpty()?"-1\n":deque.pop()+"\n");
        } else if (strs[0].equals("size")) {
            sb.append(deque.size()+"\n");
        } else if (strs[0].equals("empty")) {
            sb.append(deque.isEmpty() ? "1\n" : "0\n");
        } else if (strs[0].equals("front")) {
            sb.append(deque.isEmpty() ? "-1\n" : deque.getFirst()+"\n");
        } else if (strs[0].equals("back")) {
            sb.append(deque.isEmpty() ? "-1\n" : deque.getLast()+"\n");
        }
    }
}
