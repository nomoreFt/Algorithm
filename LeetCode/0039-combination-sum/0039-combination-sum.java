class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start){
        if(remain < 0) return;
        if(remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }   

        for(int i = start; i < candidates.length; i++){
            tempList.add(candidates[i]);
            dfs(result, tempList, candidates, remain - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}