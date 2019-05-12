package dongguabai.demo.testing.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class OfflineExamVO {

    private String examName;

    private String publisherName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishTime;


}