package dongguabai.demo.netty.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-06 23:36
 */
public class ServerSocket2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("start...");
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("===========");
            new Thread(()-> {
                try {
                    process(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void process(Socket socket) throws IOException, InterruptedException {
        TimeUnit.MILLISECONDS.sleep(20);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.write("武汉");
        writer.println("adaddaaddd");
        writer.close();
        socket.close();

    }



}
