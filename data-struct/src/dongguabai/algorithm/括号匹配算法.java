package dongguabai.algorithm;

import java.util.Stack;

/**
 * @author Dongguabai
 * @Description 括号匹配算法  (ad}ad)
 *                           (
 * @Date 创建于 2020-06-30 14:53
 */
public class 括号匹配算法 {

    public static boolean mather(String str){
        if (str == null || str.length() == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if ( c == '}' && pop != '{'){
                    return false;
                }
                if (c ==')' && pop != '('){
                    return false;
                }
                if (c == ']' && pop != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean mather2(String str){
        //todo 判空和长度为1

        Stack<Character> stack = new Stack<>();
        for (int i = 0,size = str.length(); i < size; i++) {
            char c = str.charAt(i);
            boolean left = c == '{' || c == '[' || c == '(';
            if (left){
                stack.push(c);
                continue;
            }
            if (c == '}' || c==']' || c == ')'){
                if (stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if (c == '}' && pop != '{'){
                    return false;
                }
                if (c == ']' && pop != '['){
                    return false;
                }
                if (c == ')' && pop != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(mather("(ad}ad)"));
    }
}
