package demo.dongguabai.chain_of_responsibility_pattern;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-17 11:07
 */
public interface IProcessor {

    void start();

    void process(Request request);

}
