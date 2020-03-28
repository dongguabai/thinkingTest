package dongguabai.demo.testing.i18n;

import java.util.ResourceBundle;

/**
 * @author
 * @Description
 * @Date  2019-12-13 14:55
 */
public class ResourceBundleDemo {

    public static void main(String[] args) {
        ResourceBundle test = ResourceBundle.getBundle("test");
        System.out.println(test.getString("name"));
    }
}
