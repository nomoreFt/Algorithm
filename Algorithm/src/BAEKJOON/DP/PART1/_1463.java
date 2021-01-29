package BAEKJOON.DP.PART1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
 //공부용
public class _1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		 int X = Integer.parseInt(br.readLine());
	        
	        int[] min = new int[1000001]; // 10의 6승이 최대값이기 때문에
	        
	        min[1] = 0; // 계산하기 쉬우려고 배열은 0번부터 시작하지만 인위적으로 1부터 시작하는 것처럼 만듦.
	        
	        for(int i=2; i<X+1; i++){
	            min[i] = min[i-1] +1; // 3이나 2로 나누어지지 않으면 주어진 숫자의 1 작은 수에 대한 최소 연산횟수 + (-1) 연산을 한 횟수
	            
	            if(i%2 == 0 && min[i/2] + 1 < min[i]){
	                min[i] = min[i/2] + 1; // 2로 바로 나누어 지는 경우 최솟값 비교해서 작은 연산 횟수로 대입.
	            }
	            if(i%3 == 0 && min[i/3] + 1 < min[i]){
	                min[i] = min[i/3] + 1; // 3으로 바로 나누어질 때, 대입된 값에 대한 비교가 이뤄지므로 모든 경우에 대한 비교가 성립.
	                                        // (-1) 연산이 이뤄진 횟수와 2로 바로 나누었을 때에 대한 최종 값이 마지막 min[i]에 들어오기 때문이다.
	            }
	            
	        }
	        System.out.println(min[X]);
	    }
}