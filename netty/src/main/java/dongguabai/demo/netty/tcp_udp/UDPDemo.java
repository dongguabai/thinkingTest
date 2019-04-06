package dongguabai.demo.netty.tcp_udp;

import java.io.IOException;
import java.net.*;

/**
 * @author dongguabai
 * @date 2019-04-04 12:15
 */
public class UDPDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("客户端开始准备启动...");
        //这里不传入端口号，代表是客户端
        DatagramSocket datagramSocket = new DatagramSocket();
        //要发送的信息
        String message = "美女，在干嘛呢？";
        byte[] messageBytes = message.getBytes();
        //定义一个发送的数据包
        DatagramPacket datagramPacket = new DatagramPacket(messageBytes,messageBytes.length, InetAddress.getByName("127.0.0.1"),8888);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }


}

class UDPServer{
    public static void main(String[] args) throws IOException {
        System.out.println("开始准备启动 UDP 服务...");
        //端口号，默认使用本机 IP
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //服务器端接受客户端1024个字节
        byte[] bytes = new byte[1024];
        //定义一个数据包
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        //接受客户端请求，将数据封装到数据包
            //如果客户端不给服务器端发请求，那么这个方法会一直阻塞
        datagramSocket.receive(datagramPacket);
        System.out.println("发送者 IP 和 Port 为："+datagramPacket.getAddress()+":"+datagramPacket.getPort());
        String result = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println("获取的数据为："+result);
        datagramSocket.close();
    }
}