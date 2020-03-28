package dongguabai.demo;

import java.io.IOException;

/**
 * @author dongguabai
 * @Description
 * @Date 创建于 2020-01-26 23:42
 */
public class TestDemo {

    public static void main(String[] args) throws IOException {
        DownLoadProcessor downLoadProcessor = new DownLoadProcessor("/Users/dongguabai/Desktop/images/1234.jpg","/Users/dongguabai/Desktop/images/test3.jpg");
        downLoadProcessor.start();
    }
}
