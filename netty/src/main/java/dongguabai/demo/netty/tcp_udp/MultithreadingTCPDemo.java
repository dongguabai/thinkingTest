package dongguabai.demo.netty.tcp_udp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dongguabai
 * @date 2019-04-06 09:55
 * <p>
 * 多线程改造 TCP Demo（同时接收多个请求）
 */
public class MultithreadingTCPDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(8);

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("客户端启动！");
        for (int i = 0; i < 8; i++) {
            final int b = i;
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "  准备就绪  " + b);
                    //每过一次循环就会减一，这里阻塞，直到减为0
                    countDownLatch.await();
                    requestMethod();
                    System.out.println(Thread.currentThread().getName() + "  执行完毕   " + b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
            //每过一次循环就会减一
            countDownLatch.countDown();
        }

        System.out.println("11111111");
        Thread.sleep(20000);
        System.out.println("222222");
    }

    private static void requestMethod() {
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello,World!".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class TCPServer3 {
    /**
     * 多线程处理
     */
    private static ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {
        System.out.println("服务器端启动成功！");
        //创建服务器端连接
        ServerSocket serverSocket = new ServerSocket(8080);
        //接受客户端请求，阻塞
        while (true) {
            Socket accept = serverSocket.accept();
            executor.execute(() -> {
                try {
                    InputStream inputStream = accept.getInputStream();
                    byte[] arry = new byte[1024];
                    int len = inputStream.read(arry);
                    String result = new String(arry, 0, len);
                    System.out.println(Thread.currentThread().getName() + "   收到的数据为：" + result);
                } catch (Exception e) {
                }finally {
                    if (accept!=null){
                        try {
                            accept.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}

