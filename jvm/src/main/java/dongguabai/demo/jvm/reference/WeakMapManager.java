package dongguabai.demo.jvm.reference;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakMapManager {

    public static class Element {
        private String ident;

        public Element(String id) {
            ident = id;
        }

        @Override
        public String toString() {
            return ident;
        }

        @Override
        public int hashCode() {
            return ident.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Element && ident.equals(((Element) obj).ident);
        }
    }


    public static class Key extends Element {
        public Key(String id) {
            super(id);
        }
    }

    public static class Value extends Element {
        public Value(String id) {
            super(id);
        }
    }

    public static void main(String[] args) {
        int size = 20;
        // 该数组的作用，仅仅只是维护一个强引用
        Key[] keys = new Key[size];
        Map<Key, Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0) keys[i] = k;
            map.put(k, v);
        }
        System.out.println(map);
        System.out.println("===============");
        System.gc();
        System.out.println(map);
    }
}