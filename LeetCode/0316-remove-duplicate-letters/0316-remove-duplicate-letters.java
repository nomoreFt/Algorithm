class Solution {
    public String removeDuplicateLetters(String s) {
        // 각 문자가 등장하는 마지막 인덱스를 저장하는 배열
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] visited = new boolean[26]; // 결과 문자열에 문자가 포함되었는지 여부를 추적하는 배열
        Stack<Character> stack = new Stack<>(); // 결과를 저장할 스택
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[c - 'a']) continue; // 이미 결과에 포함된 문자는 건너뜁니다.
            
            // 스택이 비어있지 않고, 스택의 최상단 문자가 현재 문자보다 크며, 스택의 최상단 문자가 뒤에 다시 등장한다면
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false; // 스택에서 제거하고 방문 여부를 갱신합니다.
            }
            
            stack.push(c); // 현재 문자를 스택에 추가합니다.
            visited[c - 'a'] = true; // 방문 여부를 갱신합니다.
        }
        
        // 스택을 문자열로 변환하여 결과를 반환합니다.
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}