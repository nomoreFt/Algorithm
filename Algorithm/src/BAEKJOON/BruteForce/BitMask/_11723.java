package BAEKJOON.BruteForce.BitMask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 비트 마스크 문제
public class _11723 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = Integer.parseInt(bf.readLine());
		int bitset = 0;
		while(cnt-- > 0) {
			String[] strs = bf.readLine().split(" ");
			
			switch(strs[0]) {
			case "add" : 
				bitset |= (1 << (Integer.parseInt(strs[1])-1));//이미 1이 0번째 자리수 차지하고 있기 때문에 들어온 숫자보다 1만큼 줄여
				break;
			case "remove" :
				bitset &= ~(1 << (Integer.parseInt(strs[1])-1));
				break;
			case "check" :
				bw.write((bitset & (1 << (Integer.parseInt(strs[1])-1))) != 0 ? "1\n" : "0\n");
				break;
			case "toggle" :
				bitset ^= (1 << (Integer.parseInt(strs[1])-1));
				break;
			case "all" : 
				bitset |= ~0;
				break;
			case "empty" :
				bitset &= 0;
				break;
			}
		}
		bf.close();
		bw.close();
	}
}
