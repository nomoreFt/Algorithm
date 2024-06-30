package Programmers.kakaoblind_2020;

public class 切弘取人伸取 {
	class Solution {
	    void match(int[][] arr, int[][] key, int rot, int r, int c){
	        int n = key.length;
	        for(int i = 0; i < n; i++){
	            for(int j = 0; j < n; j++){
	                if(rot == 0){
	                    arr[r+i][c+j] += key[i][j];
	                }else if(rot == 1){
	                    arr[r+i][c+j] += key[n-1-j][i];
	                }else if(rot == 2){
	                    arr[r+i][c+j] += key[n-1-i][n-1-j];
	                }else{
	                    arr[r+i][c+j] += key[j][n-1-i];
	                }
	            }
	        }
	    }
	    boolean check(int[][] arr, int locksize, int offset){
	        for(int i = 0; i < locksize; i++){
	            for(int j = 0; j < locksize; j++){
	                if(arr[offset+i][offset+j] != 1){
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    public boolean solution(int[][] key, int[][] lock) {
	        int offset = key.length -1;
	        int locksize = lock.length;
	        for(int r = 0; r < offset + locksize; r++){
	            for(int c = 0; c < offset + locksize; c++){
	                for(int rot = 0 ; rot < 4; rot++){
	                    int[][] arr = new int[58][58];
	                    for(int i = 0; i < locksize; i++){
	                        for(int j = 0; j < locksize; j++){
	                            arr[offset + i][offset + j] = lock[i][j];
	                        }
	                    }
	                    match(arr, key, rot, r, c);
	                    if(check(arr, locksize, offset)){
	                        return true;
	                    }
	                }
	            }
	        }
	        return false;
	    }
	}
}
