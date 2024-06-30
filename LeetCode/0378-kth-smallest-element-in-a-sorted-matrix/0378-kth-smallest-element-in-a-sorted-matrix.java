//행, 열 둘 다 asc 오름차순 정렬이라는 점 키포인트..
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while(low <= high){
            int mid = low + (high - low) / 2; //오버플로우 없이 중간 값 찾기 쌉가능
            int count = getLowerNum(matrix, mid);
            if(count < k) low = mid + 1;//k번째 작은 값은 mid보다 큰 범위에 있다.
            else high = mid - 1;//k번째 작은 값은 mid보다 작은 범위에 있다.
        }
        return low;
    }
    private int getLowerNum(int[][] matrix, int num){
        int n = matrix.length;
        int row = n - 1, col = 0;
        int res = 0;

        //맨 밑의 시작 값부터 시작해서 matrix값이 더 크면 올려(정렬 되어있으니까)
        //같거나 작으면 해당 위는 다 같거나 작은 값이니 개수 추가하고 오른쪽으로 이동
        //row는 위로 (--) 만 가고, col은 오른쪽 (++) 으로만 간다.
        while(row >= 0 && col < n){
            if(matrix[row][col] > num) //위로 올려
                row--;
            else{
                res += row + 1;//개수라 rowIdx + 1.세로로 +
                col++;//오른쪽으로 이동
            }
        }
        return res;
    }
}