package dongguabai.demo.netty.tcp_udp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * @author dongguabai
 * @date 2019-04-04 14:33
 * <p>
 * TCP 的第二个 Demo ，使用while 循环让连接不中断
 */
public class TCPDemo2 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动！");
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write((LocalDateTime.now()+"：Hello,World!").getBytes());
        }
    }
}


class TCPServer2 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端启动成功！");
        //创建服务器端连接
        ServerSocket serverSocket = new ServerSocket(8080);
        try {
            while (true) {
                Socket accept = null;
                //接受客户端请求，阻塞
                //这个方法是获取连接
                accept = serverSocket.accept();

                InputStream inputStream = accept.getInputStream();
                byte[] arry = new byte[1024];
                int len = inputStream.read(arry);
                String result = new String(arry, 0, len);
                System.out.println("收到的数据为：" + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (accept != null) {
//                accept.close();
//            }
        }
    }
}
