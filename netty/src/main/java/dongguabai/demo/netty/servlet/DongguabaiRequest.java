package dongguabai.demo.netty.servlet;
 
import java.io.IOException;
import java.io.InputStream;
 
/**
 * @author Dongguabai
 * @date 2018/10/9 21:10
 */
public class DongguabaiRequest {
 
    private String method;
    private String url;
 
    public DongguabaiRequest(InputStream is){
        String content = "";
        byte[] buff = new byte[1024];
        int len = 0;
        try {
            if ((len=is.read(buff))>0){
                content = new String(buff,0,len);
                //content
//                GET /web/user/query.json?name=zhangsan HTTP/1.1
//                User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/17.17134
//                Accept-Language: en-US,en;q=0.8,zh-Hans-CN;q=0.5,zh-Hans;q=0.3
//                Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//                Upgrade-Insecure-Requests: 1
//                Accept-Encoding: gzip, deflate
//                Host: localhost:18888
//                Connection: Keep-Alive
//                Cookie: expand_index=0; theme=bda-green-white
                //System.out.println(content);
                String line = content.split("\\n")[0];
                String[] arr = line.split("\\s");
                //获取方法参数也可以这么解析，这里就不演示了
                this.method = arr[0];
                this.url = arr[1].split("\\?")[0];
 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public String getMethod() {
        return method;
    }
 
    public String getUrl() {
        return url;
    }
}