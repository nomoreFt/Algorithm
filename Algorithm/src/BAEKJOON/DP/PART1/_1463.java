package BAEKJOON.DP.PART1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
 //���ο�
public class _1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		 int X = Integer.parseInt(br.readLine());
	        
	        int[] min = new int[1000001]; // 10�� 6���� �ִ밪�̱� ������
	        
	        min[1] = 0; // ����ϱ� ������� �迭�� 0������ ���������� ���������� 1���� �����ϴ� ��ó�� ����.
	        
	        for(int i=2; i<X+1; i++){
	            min[i] = min[i-1] +1; // 3�̳� 2�� ���������� ������ �־��� ������ 1 ���� ���� ���� �ּ� ����Ƚ�� + (-1) ������ �� Ƚ��
	            
	            if(i%2 == 0 && min[i/2] + 1 < min[i]){
	                min[i] = min[i/2] + 1; // 2�� �ٷ� ������ ���� ��� �ּڰ� ���ؼ� ���� ���� Ƚ���� ����.
	            }
	            if(i%3 == 0 && min[i/3] + 1 < min[i]){
	                min[i] = min[i/3] + 1; // 3���� �ٷ� �������� ��, ���Ե� ���� ���� �񱳰� �̷����Ƿ� ��� ��쿡 ���� �񱳰� ����.
	                                        // (-1) ������ �̷��� Ƚ���� 2�� �ٷ� �������� ���� ���� ���� ���� ������ min[i]�� ������ �����̴�.
	            }
	            
	        }
	        System.out.println(min[X]);
	    }
}