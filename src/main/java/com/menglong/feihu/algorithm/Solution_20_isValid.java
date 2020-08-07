package com.menglong.feihu.algorithm;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author lianzeng
 * @version 1.0
 * @date 2020-06-23 : 11:12
 */
public class Solution_20_isValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return
                // false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s.length() % 2 == 1) // 奇数个字符的字符串 显然无法完成括号匹配
        {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char theChar = s.charAt(i);
            if (theChar == '(' || theChar == '{' || theChar == '[') {
                stack.push(theChar);
            } else {
                if (stack.empty()) // 栈中已无左括号，此时字符为右括号，无法匹配。
                {
                    return false;
                }
                char preChar = stack.peek();
                if ((preChar == '{' && theChar == '}') || (preChar == '(' && theChar == ')') || (preChar == '[' && theChar == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }


}
