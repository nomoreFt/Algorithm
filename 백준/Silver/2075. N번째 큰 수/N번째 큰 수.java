import java.io.*;
import java.util.*;

class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                pq.offer(graph[i][j]);
                if(pq.size() > N){
                    pq.poll();
                }
            }
        }

        System.out.println(pq.poll());

    }
}