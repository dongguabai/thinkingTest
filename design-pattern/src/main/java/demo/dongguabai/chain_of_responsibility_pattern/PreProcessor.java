package demo.dongguabai.chain_of_responsibility_pattern;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-17 11:10
 */
public class PreProcessor extends Thread implements IProcessor {

    private volatile boolean finish = false;

    private LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    private IProcessor nextProcessor;

    public PreProcessor(IProcessor processor) {
        this.nextProcessor = processor;
    }

    public PreProcessor() {
    }

    public void stopProcess() {
        finish = true;
    }

    @Override
    public void process(Request request) {
        if (request != null){
            queue.add(request);
        }
    }

    @Override
    public void run() {
        while (!finish) {
            try {
                final Request take = queue.take();
                System.out.println("PreProcessor:" + take);
                if (nextProcessor != null){
                    nextProcessor.process(take);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
