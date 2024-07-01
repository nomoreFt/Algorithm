class Solution {
    public String removeDuplicateLetters(String s) {
       int[] lastIdx = new int[26];
       for(int i = 0; i < s.length(); i++){
        lastIdx[s.charAt(i) - 'a'] = i;
       }//각 문자가 등장하는 마지막 idx 저장 (앞에 나왔다면 순서상 불필요하면 제거하기 위해)

       boolean[] visited = new boolean[26];
       Deque<Character> stack = new ArrayDeque<>();
       
       for(int i = 0; i < s.length(); i++){
        char target = s.charAt(i);
    
        if(visited[target - 'a']) continue;

        while(!stack.isEmpty() && stack.peek() > target && lastIdx[stack.peek() - 'a'] > i){
            visited[stack.pop() - 'a'] = false;
        }

        stack.push(target);
        visited[target - 'a'] = true;

       }

       StringBuilder sb = new StringBuilder();
       for(char c : stack){
        sb.append(c);
       }

       return sb.reverse().toString();
    }
}





