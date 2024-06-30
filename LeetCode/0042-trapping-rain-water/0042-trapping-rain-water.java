class Solution {
    public int trap(int[] height) {
        //twoPointer
        //제일 높은 중간에 만나야 한다.
        //그러면서 왼쪽, 오른쪽의 최대 높이를 비교하고
        //더 작은쪽이 이동하면서 찾는다. 
        int left = 0;
        int right = height.length - 1;
        int waterCnt = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax <= rightMax){
                waterCnt += leftMax - height[left];
                left++;
            }else{
                waterCnt += rightMax - height[right];
                right--;
            }
        }
        return waterCnt;
    }
}