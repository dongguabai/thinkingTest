package dongguabai.demo.netty.servlet;


import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dongguabai
 * @date 2018/10/9 21:04
 */
public class DongguabaiTomcat {
 
    private int defaultPort = 8888;
    private ServerSocket server;
 
    //private Properties webXml = new Properties();
    private Map<String,DongguabaiServlet> servletMapping = new HashMap<>();
 
    private DongguabaiTomcat() {
    }
 
    public static void main(String[] args) {
        new DongguabaiTomcat().start();
    }
 
    private void start() {
        init();
        int port;
        try {
            String userPort = "8080";
            port = Integer.valueOf(userPort);
        } catch (Exception e) {
            port = defaultPort;
            e.printStackTrace();
        }
        try {
            server = new ServerSocket(port);
            System.out.println("Tomcat已经启动了，监听端口为：" + port);
            //接收用户请求
            while (true) {
                Socket socket = server.accept();
                process(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        servletMapping.put("demo1",new Demo1Servlet());
        servletMapping.put("demo2",new Demo2Servlet());
    }
 
    private void process(Socket client){
        //获取Socket对象，将Socket.getInputStream()封装成Request，Socket.getOuputStream()封装成Response
        try {
            try (OutputStream outputStream = client.getOutputStream(); InputStream inputStream = client.getInputStream();) {
                DongguabaiRequest request = new DongguabaiRequest(inputStream);
                DongguabaiResponse response = new DongguabaiResponse(outputStream);
                //实现动态调用doGet/doPost方法，并且能够自定义返回结果
                //拿到用户请求的url
                String url = request.getUrl();
                if (servletMapping.containsKey(url)) {
                    servletMapping.get(request.getUrl()).service(request, response);
                }else {
                    response.write("404-NOT FOUND");
                }
                //因为http请求是短链接，这里要关闭
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
}