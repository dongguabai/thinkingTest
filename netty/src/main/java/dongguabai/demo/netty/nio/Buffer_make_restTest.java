package dongguabai.demo.netty.nio;

import java.nio.ByteBuffer;

/**
 * @author dongguabai
 * @date 2019-04-08 16:20
 */
public class Buffer_make_restTest {

    public static void main(String[] args) {
        //创建一个大小是10的
        ByteBuffer buffer = ByteBuffer.allocate(10);
        String s = "abcde";
        buffer.put(s.getBytes());//存放5字节的
        //开启读模式
        buffer.flip();
        byte[] array = new byte[buffer.limit()];
        //这里只取两个值，就是把值放到这个 array 数组中,从0索引开始，两个长度
        buffer.get(array,0,2);
        System.out.println("读取的数据为："+new String(array));//ab
        System.out.println(buffer.position());//2
        System.out.println(buffer.limit());//5
        System.out.println(buffer.capacity());//10
        System.out.println("-------------");

        //使用一下 mark() 方法；这个方法就是让 mark = position;
        buffer.mark();

        //接下来再直接这个操作
        buffer.get(array,2,2);
        System.out.println(buffer.position());//4
        System.out.println(buffer.limit());//5
        System.out.println(buffer.capacity());//10
        System.out.println("读取的数据为："+new String(array));//abcd
    }
}
