class Solution {
    public String largestNumber(int[] nums) {
               String[] strs = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        if("0".equals(strs[0])) return "0";
        return String.join("", strs);
    }
}