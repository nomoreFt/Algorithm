package Programmers.kakaoblind_2020;

public class 가사검색 {
	class Solution {
	    class Trie{
	        int MAX = 26;
	        Trie[] child = new Trie[MAX];
	        int count;
	        int aletter = Character.getNumericValue('a'); // 소문자 값 빼기

	        void insert(String str){
	            Trie curr = this; // Root에서 시작함
	            for(char c : str.toCharArray()){
	                curr.count++; // Link 타고 내려가기전에 총 갯수 + 1
	                int idx = Character.getNumericValue(c) - aletter; // int 값으로 변환
	                if( curr.child[idx] == null) // link가 존재하는지 체크
	                    curr.child[idx] = new Trie(); // 새로운 Link 생성

	                curr = curr.child[idx]; // 새로운 링크로 이동
	            }
	            // 마지막 leaf 노드에 도착
	            curr.count++; // 마지막 leaf 노드의 값을 증가
	        }
	        int search(String str){
	            Trie curr = this; // 1. Root에서 시작함.
	            for(char ch : str.toCharArray())
	            {
	                if(ch == '?') // 와일드카드라면
	                    return curr.count; // 현재 count를 반납하면 됨.

	                curr = curr.child[Character.getNumericValue(ch) - aletter]; // 다음 링크로 이동
	                if(curr == null) // 키워드에 해당하는 단어 없음
	                    return 0; // 0개라는 뜻
	            }

	            return curr.count; // 도달하지 않음.
	        }
	    }

	    Trie[] TrieRoot = new Trie[10000]; // 정 Trie
	    Trie[] rTrieRoot = new Trie[10000]; // 뒤짚은 Trie

	    public int[] solution(String[] words, String[] queries) {
	        int[] answer = new int[queries.length]; // 정답의 갯수는 query의 갯수
	        int ansIdx = 0;

	        // words를 이용한 Trie를 만들기
	        for(String str : words)
	        {
	            // 길이가 1~10000이기때문에, 0~9999까지 인덱스 사용
	            int idx = str.length() - 1;
	            if(TrieRoot[idx] == null) // 최초라면
	            {
	                TrieRoot[idx] = new Trie();
	                rTrieRoot[idx] = new Trie();
	            }
	            TrieRoot[idx].insert(str); // 정방향 삽입
	            str = new StringBuilder(str).reverse().toString(); // 문자열 뒤짚기
	            rTrieRoot[idx].insert(str); // 역방향 삽입
	        }

	        // 검색
	        for(String str : queries){
	            int idx = str.length() - 1;
	            if(TrieRoot[idx] == null) // 아예 길이에 해당하는 경우가 없을 경우. 단어가 없는게 확실함!
	            {
	                answer[ansIdx++] = 0;
	                continue;
	            }
	            // 여기에 도달하면, Trie가 존재하다는 뜻
	            if(str.charAt(0) != '?'){ // 첫 단어가 ?가 아니면 정방향으로 서칭
	                answer[ansIdx++] = TrieRoot[idx].search(str);
	            }
	            else{ // 와일드카드로 시작하면 뒤짚어서 시작해야 함
	                str = new StringBuilder(str).reverse().toString(); // 문자열 뒤짚기
	                answer[ansIdx++] = rTrieRoot[idx].search(str);
	            }

	        }

	        return answer;
	    }
	}
}
