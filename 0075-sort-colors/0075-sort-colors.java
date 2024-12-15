class Solution {
    static int RED = 0;
    static int WHITE = 1;
    static int BLUE = 2;

    public void sortColors(int[] nums) {
        
        int low = 0;
        int high = nums.length-1;
        int current = 0;

        while(current <= high){
            if(nums[current] == RED){
                swap(low, current, nums);
                low++;
                current++;
            }else if(nums[current] == BLUE){
                swap(high, current, nums);
                high--;
            }else{
                current++;
            }
        }
    }

    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}