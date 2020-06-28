package dongguabai.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-24 09:16
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "address")
public class Invoker {

    private String address;

    /**
     * 权重
     */
    private int weight = 1;

    private int currentWeight = 0;

    public Invoker(String address) {
        this.address = address;
    }

    public Invoker(String address, int weight) {
        this.address = address;
        this.weight = weight;
    }
}
