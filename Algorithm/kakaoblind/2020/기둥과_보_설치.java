package Programmers.kakaoblind_2020;

public class 기둥과_보_설치 {
	class Solution {
	    boolean[][] Pillar;
	    boolean[][] Bar;
	    
	    int count = 0;
	    
	    boolean checkPillar(int x, int y){
	        if(y == 0 || Pillar[x][y-1]) //바닥이거나 아래에 기둥이 있다면
	            return true;
	        if ((x > 0 && Bar[x-1][y] ) || Bar[x][y])
	            return true;
	        
	        return false;
	    }
	    
	    boolean checkBar(int x, int y){
	        if(Pillar[x][y-1] || Pillar[x+1][y-1])
	            return true;
	        if(x > 0 && Bar[x-1][y] && Bar[x+1][y])
	            return true;
	        
	        return false;
	        
	    }
	    
	    boolean canDelete(int x, int y){
	        for(int i = Math.max(x-1,0); i <= x+1; i++){
	            for(int j = y; j <= y+1; j++){
	                if(Pillar[i][j] && checkPillar(i,j) == false)
	                    return false;
	                if(Bar[i][j] && checkBar(i,j) == false)
	                    return false;
	           }   
	        }
	        return true;
	    }
	    
	    public int[][] solution(int n, int[][] build_frame) {
	        Pillar = new boolean[n+2][n+2];
	        Bar = new boolean[n+2][n+2];
	        
	        for (int[] build : build_frame){
	            int x = build[0], y = build[1]; 
	            int type = build[2], cmd = build[3];
	            
	            if (type == 0) {//기둥
	                if(cmd == 1) {//설치
	                    if(checkPillar(x,y)){
	                        Pillar[x][y] = true;
	                        count++;
	                    }
	                }else{
	                    Pillar[x][y] = false;
	                    if(canDelete(x,y) == false){
	                        Pillar[x][y] = true;
	                    }else {
	                        count--;
	                    }
	                }
	            }else{//보
	                if(cmd == 1){
	                    if(checkBar(x,y)){
	                        Bar[x][y] = true;
	                        count++;
	                    }
	                }else{
	                    Bar[x][y] = false;
	                    if(canDelete(x,y) == false){
	                        Bar[x][y] = true;
	                    }else{
	                        count--;
	                    }
	                }
	            }
	        }
	        
	        int[][] answer = new int[count][3];
	        count = 0;
	        
	        for(int x = 0; x <= n; x++){
	            for(int y = 0; y <= n; y++){
	                if(Pillar[x][y]){
	                    answer[count][0] = x;
	                    answer[count][1] = y;
	                    answer[count++][2] = 0;
	                }
	                if(Bar[x][y]){
	                    answer[count][0] = x;
	                    answer[count][1] = y;
	                    answer[count++][2] = 1;
	                }
	            }
	        } 
	        return answer;
	    }
	}
}
