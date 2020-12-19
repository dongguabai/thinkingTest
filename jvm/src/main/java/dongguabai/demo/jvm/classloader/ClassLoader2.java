package dongguabai.demo.jvm.classloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-30 18:54
 */
public class ClassLoader2 extends ClassLoader{


    public Class aaa(String nama, File file) throws IOException {

        final byte[] bytes = FileUtils.readFileToByteArray(file);

        return defineClass(nama,bytes,0,bytes.length);
    }

    public static void main(String[] args) throws IOException {
        String name = "dongguabai.demo.jvm.classloader.ObjectDemo";
        File file = new File("/Users/dongguabai/IdeaProjects/thinkingTest/jvm/src/main/java/dongguabai/demo/jvm/classloader/ObjectDemo.class");
        File file2 = new File("/Users/dongguabai/IdeaProjects/thinkingTest/jvm/src/main/java/dongguabai/demo/jvm/ObjectDemo.class");
        /*ClassLoader2 loader2 = new ClassLoader2();
        final Class class2 = loader2.aaa(name, file);

        ClassLoader1 loader1 = new ClassLoader1();
        final Class class1 = loader1.aaa(name, file);
        final Class class12 = loader1.aaa(name, file);

        System.out.println(class1);
        System.out.println(class2);
        System.out.println(String.class);

        System.out.println(class1 == class2);
        System.out.println(class12 == class1);
    }*/

        ClassLoader2 loader2 = new ClassLoader2();
        final Class class2 = loader2.aaa(name, file2);
        final Class class1 = loader2.aaa(name, file);

        System.out.println(class1);
        System.out.println(class2);
        System.out.println(class1 == class2);

    }
}
