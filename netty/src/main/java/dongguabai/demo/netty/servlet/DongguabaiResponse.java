package dongguabai.demo.netty.servlet;
 
import java.io.IOException;
import java.io.OutputStream;
 
/**
 * @author Dongguabai
 * @date 2018/10/9 21:10
 */
public class DongguabaiResponse {
 
    private OutputStream os;
 
    public DongguabaiResponse(OutputStream os){
        this.os = os;
    }
 
    public void write(String outString) throws IOException {
        os.write(outString.getBytes());
    }
}