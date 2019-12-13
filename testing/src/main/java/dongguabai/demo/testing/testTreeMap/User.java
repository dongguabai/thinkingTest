package dongguabai.demo.testing.testTreeMap;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.HashCodeExclude;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-08-25 00:46
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private Integer seq;

}
