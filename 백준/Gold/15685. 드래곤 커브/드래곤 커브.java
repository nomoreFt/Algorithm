import java.io.*;
import java.sql.Array;
import java.util.*;


class Main {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int N;
    static boolean[][] graph = new boolean[101][101];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int T = 0; T < N; T++) {
            String[] strs = br.readLine().split(" ");

            int y = Integer.parseInt(strs[0]);
            int x = Integer.parseInt(strs[1]);
            int d = Integer.parseInt(strs[2]);
            int g = Integer.parseInt(strs[3]);

            //드래곤 커브 개수만큼 반복
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(d);
            graph[x][y] = true;
            for (int i = 1; i <= g; i++) {
                ArrayList<Integer> reverseArr = new ArrayList<>(arr);
                Collections.reverse(reverseArr);
                int size = reverseArr.size();
                for (int j = 0; j < size; j++) {
                    arr.add((reverseArr.get(j)+1)%4);
                }
            }

            int arrSize = arr.size();
            for (int i = 0; i < arrSize; i++) {
                int dir = arr.get(i);
                int nX = x + dx[dir];
                int nY = y + dy[dir];
                graph[nX][nY] = true;
                x = nX;
                y = nY;
            }
        }

        int ans= 0;
        for (int i = 0; i < 100; i+=1) {
            for (int j = 0; j < 100; j+=1) {
                if (graph[i][j] && graph[i + 1][j]
                        && graph[i][j + 1] && graph[i + 1][j + 1]) {
                   ans++;
                }
            }
        }
        System.out.println(ans);

    }
}




