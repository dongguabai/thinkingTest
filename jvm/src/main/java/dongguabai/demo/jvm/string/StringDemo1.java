package dongguabai.demo.jvm.string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-09 13:10
 */
public class StringDemo1 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = new String(new int[]{0x1F602}, 0, 1);
        String s2 = "\\xF0\\x9F\\x98\\x81";
        String s1 = s2.replaceAll("\\\\x", "%");
        String decode = URLDecoder.decode(s1, "utf-8");
        System.out.println(decode);

        System.out.println(s);
    }


}
