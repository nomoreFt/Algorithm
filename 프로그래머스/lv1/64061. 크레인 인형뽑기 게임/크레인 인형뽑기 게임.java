import java.util.*;
class Solution {
  public int solution(int[][] board, int[] moves) {
			int answer = 0;
			Stack<Integer> stack = new Stack<Integer>();
			for (int move : moves) {
				int fixedLine = move - 1;
				for (int i = 0; i < board.length; i++) {
					int head = board[i][fixedLine];
					if (head == 0)
						continue;
					if (!stack.empty() && stack.peek() == head) {
						stack.pop();
						answer++;
					} else {
						stack.push(head);
					}
					board[i][fixedLine] = 0;
					break;
				}
			}
			return answer * 2;
		}
}