import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // 초기 인덱스를 스택에 추가

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // 여는 괄호의 인덱스를 스택에 추가
            } else {
                stack.pop(); // 닫는 괄호를 만나면 스택에서 하나를 뺌
                if (stack.isEmpty()) {
                    stack.push(i); // 스택이 비어있으면 현재 인덱스를 스택에 추가
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek()); // 최대 길이를 갱신
                }
            }
        }
        System.out.println(maxLength);
    }
}