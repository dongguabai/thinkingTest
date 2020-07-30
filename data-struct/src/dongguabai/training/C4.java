package dongguabai.training;

import java.util.Stack;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-07-30 15:42
 */
public class C4 {

    public static boolean mather(String str){
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
        String s = "{{{11{[adad]}}}}";
        System.out.println(mather(s));
    }
}
