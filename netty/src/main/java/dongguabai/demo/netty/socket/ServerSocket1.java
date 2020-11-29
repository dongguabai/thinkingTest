package dongguabai.demo.netty.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-06 23:36
 */
public class ServerSocket1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("start...");
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("===========");
            process(socket);
        }
    }

    private static void process(Socket socket) throws IOException, InterruptedException {
        TimeUnit.MILLISECONDS.sleep(20);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.write("武汉");
        writer.close();
        socket.close();

    }



}
