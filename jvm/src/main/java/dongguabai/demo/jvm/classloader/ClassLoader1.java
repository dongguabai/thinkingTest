package dongguabai.demo.jvm.classloader;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-30 18:54
 */
public class ClassLoader1 extends ClassLoader{


    public Class aaa(String nama, File file) throws IOException {

        final byte[] bytes = FileUtils.readFileToByteArray(file);

        return defineClass(nama,bytes,0,bytes.length);
    }


}
