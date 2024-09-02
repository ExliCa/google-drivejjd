package googledrivejjd.domain;

import googledrivejjd.domain.*;
import googledrivejjd.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoStreamed extends AbstractEvent {

    private Long id;
    private String stramingId;
    private String fileId;
    private String fileName;
    private String streamingUrl;
    private Date processDate;
}
