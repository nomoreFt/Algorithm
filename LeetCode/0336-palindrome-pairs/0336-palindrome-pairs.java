class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Trie t = new Trie();
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            t.insert(words[i],i);
        }
        
        for(int i = 0; i < words.length; i++){
            results.addAll(t.search(words[i],i));
        }
        return results;
        
    }

    static class TrieNode{
        TrieNode[] children;
        int wordId;
        List<Integer> palindromeWordIds;
        
        public TrieNode(){
            wordId = -1;
            children = new TrieNode[26];
            palindromeWordIds = new ArrayList<>();
        }
    }

    static class Trie{
        TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }

        public boolean isPalindrome(String str, int start, int end){
            while(start < end){
                if(str.charAt(start++) != str.charAt(end--)) return false;
            }
            return true;
        }

        public void insert(String word, int index){
            TrieNode cur = root;
            //Trie에 역순으로 삽입한다.
            for(int i = word.length() - 1; i >= 0; i--){
                char c = word.charAt(i);
                if(cur.children[c-'a'] == null){
                    cur.children[c-'a'] = new TrieNode();
                }
                //지금 팰린드롬일 경우 누가 팰린드롬인지 Index 꼬리 달기
                if(isPalindrome(word, 0, i)){
                    cur.palindromeWordIds.add(index);
                }
                cur = cur.children[c-'a'];
            }
            cur.wordId = index;
        }

        public List<List<Integer>> search(String word, int index){
            TrieNode cur = root;
            List<List<Integer>> result = new ArrayList<>();
            //찾을 떈 정순서
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.wordId >= 0 
                && isPalindrome(word, i, word.length() - 1)){
                    result.add(Arrays.asList(new Integer[]{index, cur.wordId}));
                }
                
                if(cur.children[c - 'a'] == null) return result;

                cur = cur.children[c-'a'];
            }

            if(cur.wordId >= 0 && cur.wordId != index){
                result.add(Arrays.asList(new Integer[]{index, cur.wordId}));
            }
            for(int palindromeWordId : cur.palindromeWordIds){
                result.add(Arrays.asList(new Integer[]{index, palindromeWordId}));
            }
            return result;
        }
    }
}