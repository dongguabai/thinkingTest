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
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-------------");

        String s = "abcde";
        buffer.put(s.getBytes());//存放5字节的
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-------------");
        //开启读
        buffer.flip();
        byte[] array = new byte[buffer.limit()];
        buffer.get(array);
        System.out.println("读取的数据为："+new String(array));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-------------");
    }
}
