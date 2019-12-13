
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-05-20 00:18
 */
public class For520 {

    /**
     * Scanner的简单示例
     * */

        public static void main(String[] args) {

            //创建Scanner对象
            //System.in表示标准化输出，也就是键盘输出
            Scanner sc = new Scanner(System.in);
            System.out.println("在这个特殊的日子，您想表达什么：");
            String str = sc.next();
            System.out.println("每隔多久（秒）表达一次：");
            Scanner sc2 = new Scanner(System.in);

            String str2 = sc2.next();
            while ("1".equals(str2)) {
                System.out.println("收到！");
                break;
            }

            try {
                FileInputStream input = new FileInputStream("/Users/dongguabai/Desktop/temp/520.txt");
                // read() 从此输入流中读取一个数据字节。
                // read(byte[] b) 从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
                byte[] b = new byte[input.available()];
                input.read(b);
                // 打印
                String str3=new String(b);
                int i = 1;
                while (true){
                    System.out.println("您在 "+LocalDateTime.now().toString().replace("T"," ")+" 第"+i+"次表达：");
                    System.out.println(str3);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
