class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        return Integer.bitCount(xor);
    
    }
}