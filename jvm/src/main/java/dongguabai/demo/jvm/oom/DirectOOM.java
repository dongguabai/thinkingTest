package dongguabai.demo.jvm.oom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-23 01:47
 */
public class DirectOOM {

    public static void main(String[] args) {
        final int _1M = 1024 * 1024;
        List<ByteBuffer> buffers = new ArrayList<>();
        int count = 1;
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1M);
            buffers.add(byteBuffer);
            System.out.println(count++);
        }
    }
}
