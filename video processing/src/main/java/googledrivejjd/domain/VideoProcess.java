package googledrivejjd.domain;

import googledrivejjd.VideoProcessingApplication;
import googledrivejjd.domain.VideoStreamed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "VideoProcess_table")
@Data
//<<< DDD / Aggregate Root
public class VideoProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String stramingId;

    private String fileId;

    private String fileName;

    private String streamingUrl;

    private Date processDate;

    @PostPersist
    public void onPostPersist() {
        VideoStreamed videoStreamed = new VideoStreamed(this);
        videoStreamed.publishAfterCommit();
    }

    public static VideoProcessRepository repository() {
        VideoProcessRepository videoProcessRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoProcessRepository.class
        );
        return videoProcessRepository;
    }

    //<<< Clean Arch / Port Method
    public static void processVideoStraming(FileIndexed fileIndexed) {
        //implement business logic here:

        /** Example 1:  new item 
        VideoProcess videoProcess = new VideoProcess();
        repository().save(videoProcess);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileIndexed.get???()).ifPresent(videoProcess->{
            
            videoProcess // do something
            repository().save(videoProcess);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void processVideoStraming(VideoUploaded videoUploaded) {
        //implement business logic here:

        /** Example 1:  new item 
        VideoProcess videoProcess = new VideoProcess();
        repository().save(videoProcess);

        */

        /** Example 2:  finding and process
        
        repository().findById(videoUploaded.get???()).ifPresent(videoProcess->{
            
            videoProcess // do something
            repository().save(videoProcess);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
