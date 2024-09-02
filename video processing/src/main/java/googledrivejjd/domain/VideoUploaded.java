package googledrivejjd.domain;

import googledrivejjd.domain.*;
import googledrivejjd.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoUploaded extends AbstractEvent {

    private Long id;
    private String fileId;
    private Float fileSize;
    private String fileName;
    private String uploadYn;
    private Date uploadDate;
    private String indexYn;
}
