package dongguabai.demo.netty.nio;


import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.nio.ByteBuffer;

/**
 * @author dongguabai
 * @date 2019-04-06 13:05
 * 缓冲区：在 NIO 中主要用来存放数据传输文件，和通道一起配合使用
 */
public class BufferTest {

    @Test
    public void test1() {
        //allocate 是分配的意思，这个方法是给 Buffer 分配capacity容量
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());   //1024
        System.out.println(buffer.capacity());//1024
        System.out.println("往 Buffer 中存入数据！-------------------------");
        //这里存入了一个 5 个字节的数据
        buffer.put("abcde".getBytes());
        System.out.println(buffer.position());//5
        System.out.println(buffer.limit());   //1024
        System.out.println(buffer.capacity());//1024
        System.out.println("一个错误的读取数据的方式-----------------------------");
//        byte[] array = new byte[buffer.limit()];
        byte[] array = new byte[1];
        //读取数据放到 array 中去
        buffer.get(array);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        String s = new String(array);
        System.out.println(s.length());
        System.out.println("读取到的结果为：" + s);
        System.out.println(StringUtils.equals(s, new String(new byte[1])));
        System.out.println("正确的方式开启读取模式----------------------");
        //开启读操作
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        byte[] array2 = new byte[buffer.limit()];
        //读取数据放到 array 中去
        buffer.get(array2);
        String s2 = new String(array2);
        System.out.println(s2.length());
        System.out.println("读取到的结果为：" + s2);

        System.out.println("重复读一次------------这次读之前执行了 flip()");
        System.out.println("执行 flip() 之前的参数.....");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        buffer.flip();
        System.out.println("执行 flip() 之后的参数.....");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        byte[] array3 = new byte[buffer.limit()];
        //读取数据放到 array 中去
        buffer.get(array3);
        String s3 = new String(array3);
        System.out.println(s3.length());
        System.out.println("读取到的结果为：" + s3);
    }

    @Test
    public void test2(){
        //allocate 是分配的意思，这个方法是给 Buffer 分配capacity容量
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());   //1024
        System.out.println(buffer.capacity());//1024
        System.out.println("往 Buffer 中存入数据！-------------------------");
        //这里存入了一个 5 个字节的数据
        buffer.put("abcde".getBytes());
        System.out.println(buffer.position());//5
        System.out.println(buffer.limit());   //1024
        System.out.println(buffer.capacity());//1024
        System.out.println("一个错误的读取数据的方式-----------------------------");
//        byte[] array = new byte[buffer.limit()];
        byte[] array = new byte[1];
        //读取数据放到 array 中去
        buffer.get(array);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        String s = new String(array);
        System.out.println(s.length());
        System.out.println("读取到的结果为：" + s);
        System.out.println(StringUtils.equals(s, new String(new byte[1])));
        System.out.println("正确的方式开启读取模式----------------------");
        //开启读操作
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        byte[] array2 = new byte[buffer.limit()];
        //读取数据放到 array 中去
        buffer.get(array2);
        String s2 = new String(array2);
        System.out.println(s2.length());
        System.out.println("读取到的结果为：" + s2);
        //执行重复读取
        System.out.println("执行 rewind() 方法----------------------");
        buffer.rewind();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        byte[] array3 = new byte[buffer.limit()];
        //读取数据放到 array 中去
        buffer.get(array3);
        String s3 = new String(array3);
        System.out.println(s3.length());
        System.out.println("读取到的结果为：" + s3);
    }
}
