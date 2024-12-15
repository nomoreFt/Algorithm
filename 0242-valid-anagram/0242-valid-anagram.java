class Solution {
    public boolean isAnagram(String s, String t) {
        String sorteds = sort(s);
        String sortedt = sort(t);

        return sorteds.equals(sortedt);
    }

    public String sort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}