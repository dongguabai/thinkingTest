package dongguabai.demo.jvm.reference;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-12 12:43
 */
@Slf4j
public class PhantomReferenceDemo2 {


    public static void main(String[] args) throws IOException, InterruptedException {

        ByteClass byteClass = new ByteClass();
        ByteClass byteClass2 = new ByteClass();
        ReferenceQueue<ByteClass> queue = new ReferenceQueue<>();
        PhantomReference<ByteClass> phantomReference = new PhantomReference<>(byteClass, queue);
        PhantomReference<ByteClass> phantomReference2 = new PhantomReference<>(byteClass2, queue);

        log.error("：phantomReference:"+phantomReference);
        log.error("：byteClass："+ byteClass);
        log.error("：phantomReference2:"+phantomReference2);
        log.error("：byteClass2："+ byteClass2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        byteClass = null;
        byteClass2 = null;
        System.gc();
        System.out.println("==============GCGCGCGC========");
        Thread.sleep(2000);
        log.error("：phantomReference:"+phantomReference);
        log.error("：byteClass："+ byteClass);
        log.error("：phantomReference2:"+phantomReference2);
        log.error("：byteClass2："+ byteClass2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }

    /*private static void main1() throws InterruptedException {
        ByteClass byteClass = new ByteClass();
        TimeUnit.SECONDS.sleep(30);
        ReferenceQueue<ByteClass> queue = new ReferenceQueue<>();
        PhantomReference<ByteClass> phantomReference = new PhantomReference<>(byteClass, queue);

        log.error("：phantomReference:"+phantomReference);
        log.error("：phantomReference.get():"+phantomReference.get());
        Reference reference2 = queue.poll();
        log.error("：queue.poll()："+ reference2);
        log.error("：byteClass："+ byteClass);

        byteClass = null;
        System.gc();
        log.error("============gc==========");

        TimeUnit.SECONDS.sleep(10);
        log.error("：phantomReference:"+phantomReference);
        log.error("：phantomReference.get():"+phantomReference.get());
        Reference reference = queue.poll();
        log.error("：queue.poll()："+ reference);
        log.error("：byteClass："+ byteClass);
    }*/

}

class ByteClass{

    private byte[] bytes = new byte[2 * 1024 * 1024 * 10];

    /*@Override
    protected void finalize() throws Throwable {
        super.finalize();
    }*/

}
