class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];

        // -> 
        // X(1), [0], [0]*[1], [0]*[1]*[2]
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        //                            <-
        // X(1),      [0],       [0]*[1], [0]*[1]*[2]
        //[3][2][1]  [3]*[2]       [3]         X
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
    }
}