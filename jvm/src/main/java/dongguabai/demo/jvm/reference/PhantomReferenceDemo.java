package dongguabai.demo.jvm.reference;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-12 10:44
 */
@Slf4j
public class PhantomReferenceDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        ByteClass byteClass = new ByteClass();
        TimeUnit.SECONDS.sleep(30);
        ReferenceQueue<ByteClass> queue = new ReferenceQueue<>();
        PhantomReference<ByteClass> phantomReference = new PhantomReference<>(byteClass, queue);

        System.out.println(new Date().toLocaleString()+"：phantomReference:"+phantomReference);
        System.out.println(new Date().toLocaleString()+"：phantomReference.get():"+phantomReference.get());
        Reference reference2 = queue.poll();
        System.out.println(new Date().toLocaleString()+"：queue.poll()："+ reference2);
        System.out.println(new Date().toLocaleString()+"：byteClass："+ byteClass);
        System.out.println(byteClass);

        byteClass = null;
        System.gc();
        System.out.println("============gc==========");

        TimeUnit.SECONDS.sleep(10);
        System.out.println(new Date().toLocaleString()+"：phantomReference:"+phantomReference);
        System.out.println(new Date().toLocaleString()+"：phantomReference.get():"+phantomReference.get());
        //如果 ByteClass 重写 finalize 方法，那么这个是 null
        Reference reference = queue.poll();
        System.out.println(new Date().toLocaleString()+"：queue.poll()："+ reference);
        System.out.println(new Date().toLocaleString()+"：byteClass："+ byteClass);
        System.out.println(byteClass);

        System.in.read();
    }

}


