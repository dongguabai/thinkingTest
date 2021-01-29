package dongguabai.demo.jvm.reference.fileclean;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-12 12:49
 */
public class FileCleanerTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileCleaner fileCleaner = FileCleaner.getInstance();
        String path = "/Users/dongguabai/Desktop/temp/%d.txt";
        final List<File> files = IntStream.range(0, 10).mapToObj(i -> new File(String.format(path, i))).collect(Collectors.toList());
        files.forEach(file -> {
            try {
                file.createNewFile();
                fileCleaner.cleanWhenNecessary(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("ready.....");
        Thread.sleep(20000);
        files.clear();
        System.gc();
        System.in.read();

    }

}
