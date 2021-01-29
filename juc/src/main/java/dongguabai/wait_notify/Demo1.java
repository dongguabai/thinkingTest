package dongguabai.wait_notify;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-13 23:45
 */
@Slf4j
public class Demo1 {

    public static synchronized void main(String[] args) throws InterruptedException {
        System.out.println(1%3);
        System.out.println(2%3);
        System.out.println(3%3);
       List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            if (i%3 == 0 && i>3){
                list.remove(i);
                System.out.println(list);
            }


        }

    }
}
