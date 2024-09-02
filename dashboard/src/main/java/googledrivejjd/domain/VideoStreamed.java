package googledrivejjd.domain;

import googledrivejjd.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class VideoStreamed extends AbstractEvent {

    private Long id;
    private String StramingId;
    private String fileId;
    private String fileName;
    private String streamingUrl;
    private Date processDate;
}
