class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, k, 1);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> tempList, int n, int k , int start){
        if(tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = start; i <= n; i++){
            tempList.add(i);
            dfs(result, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    
}