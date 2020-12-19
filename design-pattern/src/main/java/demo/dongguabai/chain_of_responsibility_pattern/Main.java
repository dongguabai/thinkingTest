package demo.dongguabai.chain_of_responsibility_pattern;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-17 11:29
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        IProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        IProcessor printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
        IProcessor prePrpcessor = new PreProcessor(printProcessor);
        prePrpcessor.start();
        Request request = new Request();
        request.setId(1L);
        request.setName("张三");
        prePrpcessor.process(request);
    }
}
