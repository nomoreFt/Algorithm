import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M, K;
    static int[][] energy;
    static int[][] land;
    static ArrayList<Integer>[][] trees;

    static final int[] dx = {-1,-1,-1,0,0,1,1,1};
    static final int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        energy = new int[N][N];
        land = new int[N][N];
        trees = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                energy[i][j] = Integer.parseInt(input[j]);
                trees[i][j] = new ArrayList<>();
                land[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;
            int age = Integer.parseInt(input[2]);

            trees[x][y].add(age);
        }

        while (K-- > 0) {
            int[][] p = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //if(trees[i][j].size() == 0) continue; 있으면 하단에 겨울 처리가 안되어서 땅에 영양공급이 안됨.
                    Collections.sort(trees[i][j]);
                    ArrayList<Integer> temp = new ArrayList<>();
                    int dead = 0;
                    for (int age : trees[i][j]) {
                        if (land[i][j] >= age) {
                            land[i][j] -= age;
                            temp.add(age + 1);
                            if((age + 1) % 5 == 0){
                                for (int k = 0; k < 8; k++) {
                                    int nx = i + dx[k];
                                    int ny = j + dy[k];
                                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                                    p[nx][ny]++;
                                }
                            }
                        }else{
                            dead += age / 2;
                        }
                    }
                    trees[i][j] = temp;
                    land[i][j] += dead;
                    land[i][j] += energy[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for(int k = 0; k < p[i][j]; k++){
                        trees[i][j].add(1);
                    }
                }
            }
        }

        int ans  = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                    ans += (int)trees[i][j].size();
            }
        }

        System.out.println(ans);
    }
}