package dongguabai.demo.jvm.process;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.stream.Stream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 08:54
 */
public class PIDTest {

    public static void main(String[] args) {
        System.out.println("获取进程 ID：");
        getPidBeforeJava9();
        getPidInJava9();
        getPidInJava10();

        //ManagementFactory
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        System.out.println("获取进程启动时间（ms）：" + runtimeMXBean.getStartTime());
        System.out.println("获取进程上线时间：" + runtimeMXBean.getUptime());
        //Returns the current number of live threads including both daemon and non-daemon threads.
        System.out.println("获取当前进程活动线程数量：" + threadMXBean.getThreadCount());
        System.out.println("获取所有活动线程的线程信息（包括堆栈信息）：");
        Stream.of(threadMXBean.dumpAllThreads(true,true)).forEach(System.out::println);

        //获取内存相关信息
        ManagementFactory.getMemoryManagerMXBeans().forEach(memoryManagerMXBean -> {
            System.out.println(memoryManagerMXBean.getClass());
            System.out.println(memoryManagerMXBean.getName());
            Stream.of(memoryManagerMXBean.getMemoryPoolNames()).forEach(System.out::println);
            System.out.println("==============");
        });
        Stream.of(ManagementFactory.getPlatformMBeanServer().getDomains()).forEach(System.out::println);

        final OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        final int availableProcessors = operatingSystemMXBean.getAvailableProcessors();
        System.out.println("系统 CPU 核心数："+availableProcessors);
        System.out.println("操作系统名称："+operatingSystemMXBean.getName());
    }

    private static void getPidInJava10() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        final long pid = runtimeMXBean.getPid();
        System.out.printf("java 10 获取当前进程 ID：【%s】\n",pid);
    }

    private static void getPidBeforeJava9() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String pid = runtimeMXBean.getName().split("@")[0];
        System.out.printf("java 9 之前获取当前进程 ID：【%s】\n",pid);
    }

    private static void getPidInJava9() {
        long pid = ProcessHandle.current().pid();
        System.out.printf("java 9 获取当前进程 ID：【%s】\n",pid);
    }

}
