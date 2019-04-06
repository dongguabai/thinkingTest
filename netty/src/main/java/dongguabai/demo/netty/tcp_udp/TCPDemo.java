package dongguabai.demo.netty.tcp_udp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dongguabai
 * @date 2019-04-04 14:33
 */
public class TCPDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动！");
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello,World!".getBytes());
        }
    }
}


class TCPServer{
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端启动成功！");
        //创建服务器端连接
        ServerSocket serverSocket = new ServerSocket(8080);
        //接受客户端请求，阻塞
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        byte[] arry = new byte[1024];
        int len = inputStream.read(arry);
        String result = new String(arry,0,len);
        System.out.println("收到的数据为："+result);
        accept.close();
    }
}
