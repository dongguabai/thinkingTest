package dongguabai.code.interview.single;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author dongguabai
 * @date 2019-03-19 10:30
 *
 * 使用 fork/join 获取字符串中的小写字母数量
 */
public class CountStringLowTask extends RecursiveTask<Integer> {

    private String str;

    //拆分阈值
    private Integer sub;

    @Override
    protected Integer compute() {

        if (str.length()>sub){
            String s1 = str.substring(0, sub);
            String s2 = str.substring(sub);
            CountStringLowTask task1 = new CountStringLowTask(s1,sub);
            CountStringLowTask task2 = new CountStringLowTask(s2,sub);
            task1.fork();
            task2.fork();
            return task1.join()+task2.join();
        }

        return count(str);
    }

    public CountStringLowTask(String str, Integer sub) {
        this.str = str;
        this.sub = sub;
    }

    private static Integer count(String str){
        Integer result = 0;
        for (char c : str.toCharArray()) {
            if (c>='a' && c<='z'){
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> future = forkJoinPool.submit(new CountStringLowTask("    public CalculatedForkJoinRecursiveTask(int start, int end, int maxThreshold) {\n",3));
        System.out.println(future.get());
        System.out.println(count("    public CalculatedForkJoinRecursiveTask(int start, int end, int maxThreshold) {\n"));
    }

}
