class Solution {
    int alphaCnt = 26;
    public String removeDuplicateLetters(String s) {
     int len = s.length();
     int[] lastIdx = new int[alphaCnt];
     for(int i = 0; i < len; i++){
        lastIdx[s.charAt(i) - 'a'] = i;
     }

     boolean[] visited = new boolean[alphaCnt];
     Deque<Character> stack = new ArrayDeque<>();

     for(int i = 0; i < len; i++){
        char target = s.charAt(i);
        if(visited[target - 'a']) continue;
        while(!stack.isEmpty() 
        && stack.peek() > target
        && lastIdx[stack.peek() - 'a'] > i){
            visited[stack.pop() - 'a'] = false;
        }

        stack.push(target);
        visited[target - 'a'] = true;
     }

     StringBuilder sb = new StringBuilder();
     for(char c : stack){
        sb.append(c);
     }

     return sb.reverse()toString();
    }
}