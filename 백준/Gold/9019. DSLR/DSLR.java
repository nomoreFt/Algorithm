import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int T;
    static int A,B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            String[] command = new String[10000];
             boolean[] visited = new boolean[10000];
            Queue<Integer> q = new LinkedList<>();
            q.add(A);
            visited[A] = true;
            Arrays.fill(command, "");

            while(!q.isEmpty()&&!visited[B]) {
                int now = q.poll();
                int D = (now*2)%10000;
                int S = now-1==-1?9999:now-1;
                int L = (now%1000)*10 + now/1000;
                int R = (now%10)*1000 + now/10;

                if (!visited[D]) {
                    q.add(D);
                    visited[D] = true;
                    command[D] = command[now] + "D";
                }

                if (!visited[S]) {
                    q.add(S);
                    visited[S] = true;
                    command[S] = command[now] + "S";
                }

                if (!visited[L]) {
                    q.add(L);
                    visited[L] = true;
                    command[L] = command[now] + "L";
                }

                if (!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    command[R] = command[now] + "R";
                }
            }
            System.out.println(command[B]);


        }
    }
}