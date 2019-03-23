package dongguabai.demo.juc.future.myfuture2;

/**
 * @author dongguabai
 * @date 2019-03-24 01:31
 */
@FunctionalInterface
public interface MyCallback<V> {

    void callback(V v);
}
