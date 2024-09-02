package googledrivejjd.domain;

import googledrivejjd.DriveApplication;
import googledrivejjd.domain.FileUploaded;
import googledrivejjd.domain.VideoUploaded;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Drive_table")
@Data
//<<< DDD / Aggregate Root
public class Drive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileId;

    private Float fileSize;

    private String fileName;

    private String uploadYn;

    private Date uploadDate;

    private String indexYn;

    @PostPersist
    public void onPostPersist() {
        FileUploaded fileUploaded = new FileUploaded(this);
        fileUploaded.publishAfterCommit();

        VideoUploaded videoUploaded = new VideoUploaded(this);
        videoUploaded.publishAfterCommit();
    }

    public static DriveRepository repository() {
        DriveRepository driveRepository = DriveApplication.applicationContext.getBean(
            DriveRepository.class
        );
        return driveRepository;
    }
}
//>>> DDD / Aggregate Root
