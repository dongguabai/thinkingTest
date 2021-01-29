package dongguabai.demo.jvm.reference.fileclean;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-12 12:22
 */
@Slf4j
public class FileCleaner {

    private ReferenceQueue<File> rq = new ReferenceQueue<>();

    private Map<String,Recorder> dummy_record = new ConcurrentHashMap<>();

    private static volatile FileCleaner INSTANCE;

    private static final Object LOCK = new Object();

    private FileCleaner() {
        Cleaner cleaner = new Cleaner();
        cleaner.start();
    }

    //添加删除文件
    public void cleanWhenNecessary(File file) {
        if (file == null) {
            return;
        }
        dummy_record.put(file.getPath(),new Recorder(file.getPath(), file, rq));
    }


    public static FileCleaner getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new FileCleaner();
                }
            }
        }
        return INSTANCE;
    }

    //清除线程
    private final class Cleaner extends Thread {
        private Cleaner() {
            super("File-cleaner");
            setDaemon(true);
            setPriority(MAX_PRIORITY);
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    Recorder recorder = (Recorder) rq.remove();
                    final boolean delete = new File(recorder.path).delete();
                    dummy_record.remove(recorder.path);
                    System.out.printf("删除【%s】,结果：【%s】\n", recorder.path, delete);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static final class Recorder extends PhantomReference<File> {
        //文件路径
        private String path;

        private Recorder(String path, File file, ReferenceQueue<File> queue) {
            super(file, queue);
            this.path = path;
        }
    }
}
