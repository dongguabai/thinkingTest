package dongguabai.demo;

import jdk.internal.ref.Cleaner;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-12 15:25
 */
public class T1 {

    public static void main(String[] args) throws IOException {
        User user = new User();
        User user2 = new User();
        Cleaner.create(user,()->{
            System.out.println("回收了。。。。。");
        });
        Cleaner.create(user2,()->{
            System.out.println("回收了222。。。。。");
        });
        user = null;
        user2 = null;
        System.gc();
        System.out.println("===========gc");
        System.in.read();
    }
}

class User{

}
