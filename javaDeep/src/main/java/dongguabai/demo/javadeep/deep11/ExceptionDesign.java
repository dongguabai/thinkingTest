package dongguabai.demo.javadeep.deep11;

/**
 * @author dongguabai
 * @date 2019-04-03 10:08
 * 异常设计
 */
public class ExceptionDesign {

    public static void main(String[] args) {
        try {
            dosth();
        } catch (Exception e) {
            throw new RuntimeException("发生了异常",e);
        }
    }

    private static void dosth() throws Exception{
        System.out.println("------");
        int i = 1/0;
    }
}
