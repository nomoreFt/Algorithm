package Programmers.kakaoblind_2020;

public class ����˻� {
	class Solution {
	    class Trie{
	        int MAX = 26;
	        Trie[] child = new Trie[MAX];
	        int count;
	        int aletter = Character.getNumericValue('a'); // �ҹ��� �� ����

	        void insert(String str){
	            Trie curr = this; // Root���� ������
	            for(char c : str.toCharArray()){
	                curr.count++; // Link Ÿ�� ������������ �� ���� + 1
	                int idx = Character.getNumericValue(c) - aletter; // int ������ ��ȯ
	                if( curr.child[idx] == null) // link�� �����ϴ��� üũ
	                    curr.child[idx] = new Trie(); // ���ο� Link ����

	                curr = curr.child[idx]; // ���ο� ��ũ�� �̵�
	            }
	            // ������ leaf ��忡 ����
	            curr.count++; // ������ leaf ����� ���� ����
	        }
	        int search(String str){
	            Trie curr = this; // 1. Root���� ������.
	            for(char ch : str.toCharArray())
	            {
	                if(ch == '?') // ���ϵ�ī����
	                    return curr.count; // ���� count�� �ݳ��ϸ� ��.

	                curr = curr.child[Character.getNumericValue(ch) - aletter]; // ���� ��ũ�� �̵�
	                if(curr == null) // Ű���忡 �ش��ϴ� �ܾ� ����
	                    return 0; // 0����� ��
	            }

	            return curr.count; // �������� ����.
	        }
	    }

	    Trie[] TrieRoot = new Trie[10000]; // �� Trie
	    Trie[] rTrieRoot = new Trie[10000]; // ��¤�� Trie

	    public int[] solution(String[] words, String[] queries) {
	        int[] answer = new int[queries.length]; // ������ ������ query�� ����
	        int ansIdx = 0;

	        // words�� �̿��� Trie�� �����
	        for(String str : words)
	        {
	            // ���̰� 1~10000�̱⶧����, 0~9999���� �ε��� ���
	            int idx = str.length() - 1;
	            if(TrieRoot[idx] == null) // ���ʶ��
	            {
	                TrieRoot[idx] = new Trie();
	                rTrieRoot[idx] = new Trie();
	            }
	            TrieRoot[idx].insert(str); // ������ ����
	            str = new StringBuilder(str).reverse().toString(); // ���ڿ� ��¤��
	            rTrieRoot[idx].insert(str); // ������ ����
	        }

	        // �˻�
	        for(String str : queries){
	            int idx = str.length() - 1;
	            if(TrieRoot[idx] == null) // �ƿ� ���̿� �ش��ϴ� ��찡 ���� ���. �ܾ ���°� Ȯ����!
	            {
	                answer[ansIdx++] = 0;
	                continue;
	            }
	            // ���⿡ �����ϸ�, Trie�� �����ϴٴ� ��
	            if(str.charAt(0) != '?'){ // ù �ܾ ?�� �ƴϸ� ���������� ��Ī
	                answer[ansIdx++] = TrieRoot[idx].search(str);
	            }
	            else{ // ���ϵ�ī��� �����ϸ� ��¤� �����ؾ� ��
	                str = new StringBuilder(str).reverse().toString(); // ���ڿ� ��¤��
	                answer[ansIdx++] = rTrieRoot[idx].search(str);
	            }

	        }

	        return answer;
	    }
	}
}
