import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 输入：s = "()"
 * 输出：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 输入：s = "(]"
 * 输出：false
 */
public class LeetCode05 {
    public static void main(String[] args) {
        String str = "(){}[]";
        isVal(str);
    }

    private static boolean isVal(String str) {
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList();
        for (int i = 0; i < str.length(); i++) {
            // 如果匹配到右括号,就将左括号出栈,否侧左括号入栈
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || map.get(ch) != stack.peek()) {
                    // 如果栈为空 且 栈顶的值 不匹配与括号
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);//入栈 左括号
            }
        }
        return stack.isEmpty();// 栈为空表示 完全匹配
    }
}


