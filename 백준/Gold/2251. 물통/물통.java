import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int A,B,C;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        A = Integer.parseInt(strs[0]);
        B = Integer.parseInt(strs[1]);
        C = Integer.parseInt(strs[2]);
        visited = new boolean[A+1][B+1][C+1];

        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0,C});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];
            if(visited[a][b][c]) continue;
            visited[a][b][c] = true;
            if(a==0) ans.add(c);
            
            //A+B가 B보다 크면 B가 가득차고 A+B-B가 A에 남음
            //A+B가 B보다 작으면 A+B가 B에 남고 A가 0이됨
            if(a+b>B) q.add(new int[]{a+b-B,B,c});
            else q.add(new int[]{0,a+b,c});
            //A+C가 C보다 크면 C가 가득차고 A+C-C가 A에 남음
            //A+C가 C보다 작으면 A+C가 C에 남고 A가 0이됨
            if(a+c>C) q.add(new int[]{a+c-C,b,C});
            else q.add(new int[]{0,b,a+c});
            //B+A가 A보다 크면 A가 가득차고 B+A-A가 B에 남음
            //B+A가 A보다 작으면 B+A가 A에 남고 B가 0이됨
            if(b+a>A) q.add(new int[]{A,b+a-A,c});
            else q.add(new int[]{b+a,0,c});
            //B+C가 C보다 크면 C가 가득차고 B+C-C가 B에 남음
            //B+C가 C보다 작으면 B+C가 C에 남고 B가 0이됨
            if(b+c>C) q.add(new int[]{a,b+c-C,C});
            else q.add(new int[]{a,0,b+c});
            //C+A가 A보다 크면 A가 가득차고 C+A-A가 C에 남음
            //C+A가 A보다 작으면 C+A가 A에 남고 C가 0이됨
            if(c+a>A) q.add(new int[]{A,b,c+a-A});
            else q.add(new int[]{c+a,b,0});
            //C+B가 B보다 크면 B가 가득차고 C+B-B가 C에 남음
            //C+B가 B보다 작으면 C+B가 B에 남고 C가 0이됨
            if(c+b>B) q.add(new int[]{a,B,c+b-B});
            else q.add(new int[]{a,c+b,0});
        }

        Collections.sort(ans);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}