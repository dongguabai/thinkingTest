package dongguabai.thread;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 00:15
 */
public class Test {
    public static void main(String[] args) {

        getP();

        Thread aThread = new Thread("aa");

        System.out.println("======");
        getP();
    }

    private static void getP() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
// 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
// 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
// 获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slackList);
// copy into a list that is the exact size
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);
        System.out.println("Thread list size == " + list.length);
        for (Thread thread : list) {
            System.out.println(thread.getName());
        }
    }
}
