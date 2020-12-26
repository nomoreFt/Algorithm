package BAEKJOON.BruteForce.Permutation;

import java.io.*;

import java.util.*;
public class _6603 {
    public static int[] lotto;
    public static int[] answer;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while(!input.equals("0")){
            String[] temp = input.split(" ");
            lotto = new int[temp.length-1];
            answer = new int[temp.length-1];

            int k = Integer.parseInt(temp[0]);

            for(int i=1;i<temp.length;i++){
                lotto[i-1] = Integer.parseInt(temp[i]);
            }
            dfs(0,0, k);
            System.out.println();

            input = scan.nextLine();
        }
    }

    public static void dfs(int idx, int depth,int k){
        if(depth==6){ // 6개의 순열이 만들어지면 출력후 return
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<6;i++){ // 자바의 System 호출을 여러번 하는것은 효율이 좋지 않으므로 한꺼번에 출력한다.
                stringBuilder.append(answer[i]+" ");
            }
            System.out.println(stringBuilder.toString().trim()); 
            return;
        }
        for(int i=idx;i<k;i++){
            answer[depth] = lotto[i];
            dfs(i+1,depth+1,k);
        }
    }
}