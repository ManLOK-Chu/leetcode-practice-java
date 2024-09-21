package makeTheStringGreat;

import java.util.*;

public class Solution {
    public String makeGood(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char charVal = s.charAt(i);
            if (!stack.isEmpty()) {
                char latest = stack.peek();
                if (Math.abs(charVal - latest) == 32) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(charVal);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeGood("leEeetcode"));
        System.out.println(solution.makeGood("abBAcC"));
        System.out.println(solution.makeGood("s"));
    }
}
