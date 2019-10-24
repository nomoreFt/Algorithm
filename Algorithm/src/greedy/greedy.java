package greedy;

public class greedy {
	    public int solution(int n, int[] lost, int[] reserve) {
	        int answer = 0;
	        answer = n;
	        
	        
	        for(int i = 0; i < lost.length;i++ ) {
	        	boolean rent = false;
	        	int j = 0;
	        	while(!rent) {
	        		if(j == reserve.length) break;
	        		if(lost[i]==reserve[j]) {reserve[j] = -1;rent = true;}
	        		else if(lost[i]- reserve[j] == 1) {reserve[j] = -1; rent = true;}
	        		else if(lost[i]-reserve[j] == -1) {reserve[j] = -1; rent = true;}
	        		else {j++;}
	        	}
	        	if(!rent) answer --;
	        }
	        return answer;
	        }
	}
	
