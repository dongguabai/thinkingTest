package dongguabai.code.interview.multiple.singleton_mode;

/**
 * @author dongguabai
 * @date 2019-03-27 18:13
 *
 * 静态内部类单例模式
 */
public class SingletonModeDemo {

    public static  SingletonModeDemo getInstance(){
        return A.singletonModeDemo;
    }


    private static class A{
        private static SingletonModeDemo singletonModeDemo = new SingletonModeDemo();
    }

    private SingletonModeDemo() {
    }
}
