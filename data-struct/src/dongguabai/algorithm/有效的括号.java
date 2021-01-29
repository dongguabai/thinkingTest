package dongguabai.algorithm;

import java.util.Stack;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-13 14:50
 */
public class 有效的括号 {

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    public static void main(String[] args) {
        System.out.println(isValid("[[[]]]}"));
    }


    public static boolean isValid(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()){
                return false;
            }
            final Character pop = stack.pop();
            if (c == ')' && pop != '(') {
                return false;
            }
            if (c == '}' && pop != '{') {
                return false;
            }
            if (c == ']' && pop != '[') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
