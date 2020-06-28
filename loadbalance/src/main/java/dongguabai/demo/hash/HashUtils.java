package dongguabai.demo.hash;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-27 21:45
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashUtils {

    /**
     * 引用：https://www.jianshu.com/p/4660a8a1f132
     * 计算Hash值, 使用FNV1_32_HASH算法
     *
     * @param str
     * @return
     */
    public static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }
}
