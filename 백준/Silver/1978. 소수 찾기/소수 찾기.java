import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int ans = 0,pCnt = 0;
		String[] strs = br.readLine().split(" ");
		int nums[] = new int [strs.length];
		for(int i = 0; i < cnt; i++){
			nums[i] = Integer.parseInt(strs[i]);
			for(int j = 1; j <= nums[i]/2; j++){
				if(nums[i]%j == 0) pCnt++;
			}
			if(pCnt==1) ans++;
			pCnt = 0;
		}
		System.out.print(ans);
	}
}