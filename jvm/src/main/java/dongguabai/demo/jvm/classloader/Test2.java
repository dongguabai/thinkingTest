package dongguabai.demo.jvm.classloader;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-30 00:51
 */
public class Test2 {

    class Test3{
        public Runnable returnRunable(){
            return new Runnable() {
                @Override
                public void run() {

                }
            };
        }
    }
}
