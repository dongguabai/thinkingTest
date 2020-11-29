package dongguabai.demo.testing.jackson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-05-02 10:40
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false); // 严格校验
       //dateFormat.parse(trim("2017/05/05"));
    }

/*    public static String trim(String s){
        String result = null ;
        if(null!=s && !"".equals(s)){
            result = s.replaceAll("^[　*| *| *|\\s*|\t|\r|\n]*", "").replaceAll("[　*| *| *|\\s*|\t|\r|\n]*$", "");
        }
        return result;
    }*/
}
