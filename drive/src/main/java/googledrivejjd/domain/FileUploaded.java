package googledrivejjd.domain;

import googledrivejjd.domain.*;
import googledrivejjd.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileUploaded extends AbstractEvent {

    private Long id;
    private String fileId;
    private Float fileSize;
    private String fileName;
    private String uploadYn;
    private Date uploadDate;
    private String indexYn;

    public FileUploaded(Drive aggregate) {
        super(aggregate);
    }

    public FileUploaded() {
        super();
    }
}
//>>> DDD / Domain Event
