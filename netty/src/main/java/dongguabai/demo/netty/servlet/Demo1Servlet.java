package dongguabai.demo.netty.servlet;
 
/**
 * @author Dongguabai
 * @date 2018/10/9 21:13
 */
public class Demo1Servlet extends DongguabaiServlet {
    @Override
    public void doGet(DongguabaiRequest request, DongguabaiResponse response) throws Exception {
        doPost(request,response);
    }
 
    @Override
    public void doPost(DongguabaiRequest request, DongguabaiResponse response) throws Exception {
        response.write("this is demo1");
    }
}