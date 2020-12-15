package BAEKJOON.BruteForce.Permutation;

import java.io.*;

public class _10972 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n+1];
		String[] str = br.readLine().split(" ");
		for(int i = 1 ; i <= n; i++) {
			arr[i] = Integer.parseInt(str[i-1]);
		}
		getNextPermutation(arr,n);
	}

	private static void getNextPermutation(int[] arr, int n) {
		int splitNum = n;
		int temp = 0;
		for(int i = n; i > 1; i--) {
			if(arr[i-1] < arr[i]) {
				splitNum = i-1; 
				break;
			}
		}
		
		if(splitNum == n) {
			System.out.println("-1");
			return;
		}
		//������ �迭�� �����ʳ��� ���Ͽ� �� ũ�� ��ü
		for(int j = n; j > splitNum; j--) {
			if(arr[j] > arr[splitNum]) {
				temp = arr[j];
				arr[j] = arr[splitNum];
				arr[splitNum] = temp;
				break;
			}
		}
		//���� ������ ����
		for(int k = splitNum+1; k < n; k++) {
			for(int l = k+1; l <= n; l++) {
				if(arr[k] > arr[l]) {
					temp = arr[k];
					arr[k] = arr[l];
					arr[l] = temp;
				}
			}
		}
		printArray(arr, n);
		return;
	}
	public static void printArray(int arr[], int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			if(i == n)
			sb.append(arr[i]);
			else {
				sb.append(arr[i]+" ");
			}
		}
		System.out.println(sb.toString());
	}
}
