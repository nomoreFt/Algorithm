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
        if(depth==6){ // 6���� ������ ��������� ����� return
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<6;i++){ // �ڹ��� System ȣ���� ������ �ϴ°��� ȿ���� ���� �����Ƿ� �Ѳ����� ����Ѵ�.
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