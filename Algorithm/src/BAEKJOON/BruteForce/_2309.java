package BAEKJOON.BruteForce;

import java.io.*;
import java.util.*;

public class _2309 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int dwarfCnt = 9;
		int max = 100;
		int sum = 0;
		List<Integer> dwarfs = new ArrayList<Integer>();
		for(int i = 0; i < dwarfCnt; i++) {
			dwarfs.add(Integer.parseInt(bf.readLine()));
			sum += dwarfs.get(i);
		}
		boolean checked = false;
		for(int i = 0; i < dwarfCnt; i++) {
			for(int j = i+1; j < dwarfCnt; j++) {
				if(sum - (dwarfs.get(i) + dwarfs.get(j))==max) {
					dwarfs.set(i, Integer.MIN_VALUE);
					dwarfs.set(j, Integer.MIN_VALUE);
					checked = true;
					break;
				}
				if(checked) break;
			}
		}
		Collections.sort(dwarfs);
		
		for(int dwarf : dwarfs) {
			if(dwarf != Integer.MIN_VALUE)
				sb.append(String.valueOf(dwarf)+"\n");
		}
		System.out.println(sb.toString());
		bf.close();
	}
}
