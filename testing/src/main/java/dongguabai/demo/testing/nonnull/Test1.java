package dongguabai.demo.testing.nonnull;

import org.springframework.lang.NonNull;

/**
 * @author dongguabai
 * @date 2019-03-20 23:39
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
       print(null);

    }

    private static void print(@NonNull String a){
        System.out.println(a);
    }
}
