class Solution {
    public int singleNumber(int[] nums) {
        int[] temp = new int[30000];
        for(int i : nums){
            temp[i]++;
        }
        
        int result = -1;
        for(int i = 1; i < temp.length; i++){
            if(temp[i] == 1){
                result = i;
                break;
            }
        }
        return result;
    }
}