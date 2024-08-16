class Solution {
    fun letterCombinations(digits: String): List<String> {
        val result: MutableList<String> = mutableListOf()

        if (digits.isEmpty()) return result

        val dic: MutableMap<Char, List<Char>> = mutableMapOf(
            '0' to mutableListOf(),
            '0' to mutableListOf(),
            '0' to mutableListOf(),
        )
    }
}