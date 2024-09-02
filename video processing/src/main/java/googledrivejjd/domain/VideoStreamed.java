package googledrivejjd.domain;

import googledrivejjd.domain.*;
import googledrivejjd.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VideoStreamed extends AbstractEvent {

    private Long id;
    private String stramingId;
    private String fileId;
    private String fileName;
    private String streamingUrl;
    private Date processDate;

    public VideoStreamed(VideoProcess aggregate) {
        super(aggregate);
    }

    public VideoStreamed() {
        super();
    }
}
//>>> DDD / Domain Event
