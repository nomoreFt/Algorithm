class Solution {
    public boolean isPalindrome(String s) {
        String temp = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        
        String reverse = new StringBuilder(temp).reverse().toString();

        return temp.equals(reverse);
        
    }
}