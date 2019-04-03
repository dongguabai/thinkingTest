package dongguabai.demo.javadeep.deep11;

/**
 * @author dongguabai
 * @date 2019-04-03 11:42
 * 泛型设计 Demo
 */
public class GenericTypeDemo {


    public static interface Converter<S,T>{
        T convert(S source);
    }

    public static void main(String[] args) {

    }
}
