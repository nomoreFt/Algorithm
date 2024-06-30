class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while(low <= high){
            int mid = low + (high - low) /2;//오버플로우가 나지 않는다.
            int count = getLowCount(matrix, mid);
            
            if(count < k){//k번째는 더 오른쪽
                low = mid + 1;
            }else{//k번째는 더 왼쪽
                high = mid - 1;
            }    
        }
        return low;
    }
    private int getLowCount(int[][] matrix, int mid){
        int count = 0;
        int n = matrix.length;
        
        int row = n-1;
        int col = 0;
        
        while(row >= 0 && col < n){
            if(matrix[row][col] <= mid){
                count += row + 1;
                col++;
            }else{
                row--;
            }
        }
        return count;
    }
}