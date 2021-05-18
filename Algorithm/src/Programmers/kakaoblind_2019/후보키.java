package Programmers.kakaoblind_2019;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class ÈÄº¸Å° {
	public static void main(String[] args) {
		String[][] relations = 	{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
		System.out.println(solution(relations));
	}
	
    static Comparator<Integer> comp = new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            int x = Integer.bitCount(a), y = Integer.bitCount(b);
            if( x > y) return 1;
            else if (x < y) return -1;
            else return 0;
            
        }
    };
    
   static boolean check(String[][] relation, int subset, int colsize, int rowsize){
        for(int a = 0; a < rowsize-1; a++){
            for (int b = a+1; b < rowsize; b++){
                boolean isSame = true;
                for(int k = 0; k < colsize; k++){
                    if((subset & 1<<k) ==0 ) continue;
                    if(relation[a][k].equals(relation[b][k]) == false){
                        isSame = false;
                        break;
                    }
                }
                if(isSame) return false;
            }
        }
        return true;
    }
    
    static public int solution(String[][] relation) {
        int answer = 0;
        int rowsize = relation.length;
        int colsize = relation[0].length;
        List<Integer> candidates = new LinkedList<Integer>();
        
        
        for(int i = 1; i < 1<<colsize; i++){
            if(check(relation, i, colsize, rowsize))
                candidates.add(i);
        }
        
        Collections.sort(candidates, comp);
        
        while(candidates.size() != 0){
            int n = candidates.remove(0);
            ++answer;
            
            for(Iterator<Integer> it = candidates.iterator(); it.hasNext(); ){
                int c = it.next();
                
                if((n & c) == n) it.remove();
            }
        }
        
        
        return answer;
    }
}