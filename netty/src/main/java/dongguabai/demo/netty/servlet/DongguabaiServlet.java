package dongguabai.demo.netty.servlet;
 
/**
 * @author Dongguabai
 * @date 2018/10/9 21:10
 */
public abstract class DongguabaiServlet {
 
    /**
     * Does nothing, because this is an abstract class.
     */
    public DongguabaiServlet() {
        // NOOP
    }
 
    public void service(DongguabaiRequest request,DongguabaiResponse response) throws Exception{
        //由Servie方法觉得是执行post还是get方法
        if ("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request,response);
        }else if ("POST".equalsIgnoreCase(request.getMethod())){
            doPost(request,response);
        }
    }
 
    public void destroy(DongguabaiRequest request,DongguabaiResponse response) throws Exception{
 
    }
 
    public abstract void doGet(DongguabaiRequest request, DongguabaiResponse response) throws Exception;
 
    public abstract void doPost(DongguabaiRequest request, DongguabaiResponse response) throws Exception;
}