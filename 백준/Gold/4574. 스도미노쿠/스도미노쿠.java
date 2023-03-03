import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-19
 * Time: 오후 4:33
 */

public class Main
{
    static int[][] ary;
    static ArrayList<int[]> list;
    static boolean[][] rowCheck;
    static boolean[][] colCheck;
    static boolean[][] squareCheck;
    static boolean[][] domino;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    static StringBuilder sb = new StringBuilder();

    public static boolean sudoku(int index)
    {
        // 0을 다 채웠으면 출력
        if(index >= list.size())
        {
            for(int row=0; row<9; row++)
            {
                for(int col=0; col<9; col++)
                    sb.append(ary[row][col]);
                sb.append('\n');
            }

            return true;
        }

        int[] tmp = list.get(index);
        int i = tmp[0];
        int j = tmp[1];

        if(ary[i][j] != 0)
            return sudoku(index + 1);

        for(int n=1; n<10; n++)
        {
            if(!rowCheck[i][n] && !colCheck[j][n] && !squareCheck[i/3*3 + j/3][n])
            {
                ary[i][j] = n;
                rowCheck[i][n] = true;
                colCheck[j][n] = true;
                squareCheck[i/3*3 + j/3][n] = true;

                for (int k = 0; k < 2; k++)
                {
                    int newRow = i + dr[k];
                    if (newRow >= 9)
                        continue;
                    int newCol = j + dc[k];
                    if (newCol >= 9)
                        continue;

                    if(ary[newRow][newCol] != 0)
                        continue;

                    for(int n2=1; n2<10; n2++)
                    {
                        if(!rowCheck[newRow][n2] && !colCheck[newCol][n2] && !squareCheck[newRow/3*3 + newCol/3][n2] && !domino[n][n2])
                        {
                            ary[newRow][newCol] = n2;
                            rowCheck[newRow][n2] = true;
                            colCheck[newCol][n2] = true;
                            squareCheck[newRow/3*3 + newCol/3][n2] = true;
                            domino[n][n2] = true;
                            domino[n2][n] = true;

                            if(sudoku(index+1))
                                return true;

                            ary[newRow][newCol] = 0;
                            rowCheck[newRow][n2] = false;
                            colCheck[newCol][n2] = false;
                            squareCheck[newRow/3*3 + newCol/3][n2] = false;
                            domino[n][n2] = false;
                            domino[n2][n] = false;
                        }
                    }
                }

                ary[i][j] = 0;
                rowCheck[i][n] = false;
                colCheck[j][n] = false;
                squareCheck[i/3*3 + j/3][n] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;
        while(true)
        {
            int N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;

            // 스도쿠 배열 생성
            ary = new int[9][9];
            list = new ArrayList<>();

            rowCheck = new boolean[9][10];
            colCheck = new boolean[9][10];
            squareCheck = new boolean[9][10];
            domino = new boolean[10][10];

            for (int i = 0; i < N; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int U = Integer.parseInt(st.nextToken());
                String LU = st.nextToken();
                int row = LU.charAt(0) - 'A';
                int col = LU.charAt(1) - '1';
                ary[row][col] = U;

                rowCheck[row][U] = true;
                colCheck[col][U] = true;
                squareCheck[row/3*3 + col/3][U] =true;

                int V = Integer.parseInt(st.nextToken());
                String LV = st.nextToken();
                row = LV.charAt(0) - 'A';
                col = LV.charAt(1) - '1';
                ary[row][col] = V;

                rowCheck[row][V] = true;
                colCheck[col][V] = true;
                squareCheck[row/3*3 + col/3][V] = true;

                // 사용한 도미노 체크
                domino[U][V] = true;
                domino[V][U] = true;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=9; i++)
            {
                String num = st.nextToken();
                int row = num.charAt(0) - 'A';
                int col = num.charAt(1) - '1';
                ary[row][col] = i;

                rowCheck[row][i] = true;
                colCheck[col][i] = true;
                squareCheck[row/3*3 + col/3][i] = true;
            }

            for(int i=0; i<9; i++)
            {
                for(int j=0; j<9; j++)
                {
                    if(ary[i][j] == 0)
                        list.add(new int[]{i, j});
                }
            }

            sb.append("Puzzle").append(' ').append(tc).append('\n');
            sudoku(0);
            tc++;
        }

        System.out.print(sb.toString());
    }
}
