package dongguabai.code.interview.multiple.singleton_mode;

/**
 * @author dongguabai
 * @date 2019-03-27 18:13
 *
 * 双重检查锁单例模式
 */
public class SingletonModeDemo2 {

   private static volatile SingletonModeDemo2 singletonModeDemo;

   private static SingletonModeDemo2 getInstance(){
       if (singletonModeDemo == null){
           synchronized (SingletonModeDemo.class){
               if (singletonModeDemo == null ){
                   singletonModeDemo = new SingletonModeDemo2();
               }
           }
       }
       return singletonModeDemo;
   }
}
