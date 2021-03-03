package codingTest.Sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.RowFilter.ComparisonType;

public class 두_배열의_원소_교체 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];
		for(int i = 0 ; i < 2; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				if(i == 0) {
					A[j] = Integer.parseInt(str[j]);
				}else {
					B[j] = Integer.parseInt(str[j]);
				}
			}
		}
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		for(int i = 0; i < K; i++) {
			if(A[i] < B[i]) {
				int temp = A[i];
				A[i] = B[i];
				B[i] = temp;
			}
		}
		long result = 0;
		for(int i = 0; i < N; i++) {
			result += A[i];
		}
		System.out.println(result);
	}
}
