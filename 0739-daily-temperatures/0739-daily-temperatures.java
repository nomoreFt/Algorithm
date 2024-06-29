class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() 
            && temperatures[i] > temperatures[stack.peek()]){
                int targetIdx = stack.pop();
                result[targetIdx] = i - targetIdx;
            }
            stack.push(i);
        }
        
        return result;
    }
}