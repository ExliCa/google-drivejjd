package googledrivejjd.domain;

import googledrivejjd.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class FileIndexed extends AbstractEvent {

    private Long id;
    private String indexId;
    private String fileId;
    private String fileName;
    private String indexYn;
}
