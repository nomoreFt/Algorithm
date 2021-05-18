package BAEKJOON.BruteForce.BitMask;

public class 비트연습 {

	public static void main(String[] args) {
		char[] data = {'A' , 'B', 'C', 'D'};
		printSubsets(data,4);
	}
	public static void printSubsets(char[] arr, int N) {
		for(int i = 0; i < 1<<N; i++) {
			if(Integer.bitCount(i)!=3) {
				continue;
			}
			System.out.print("{");
			for(int j = 0; j < N ; j++) {
				if( (i & 1<<j) != 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.print("}\n");
		}
	}

}
