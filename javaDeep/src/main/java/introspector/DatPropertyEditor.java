package introspector;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期属性编辑器
 */
public class DatPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        try {
            setValue((text == null) ? null : new SimpleDateFormat("yyyy-MM-dd").parse(text));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParseException {
        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-10");
        System.out.println(parse);
    }
}
