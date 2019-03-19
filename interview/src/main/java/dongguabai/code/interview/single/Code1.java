package dongguabai.code.interview.single;

/**
 * @author dongguabai
 * @date 2019-03-19 10:11
 *
 * link：https://blog.csdn.net/Dongguabai/article/details/84789255
 *
 * Q：请编写线程 A，A 需要满足：（1）循环执行一个任务 doTask()；（2）外部线程可以中断线程A；
 */
public class Code1 {

    //增加中断标记位
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {


        new Thread(()->{
            while (!stop){
                doTask();
            }
        }).start();

        Thread.sleep(3000);

        new Thread(()->{
            System.out.println("终止线程。。。。");
            stop = true;
        }).start();
    }

    static void doTask(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行 任务....");
    }

}
