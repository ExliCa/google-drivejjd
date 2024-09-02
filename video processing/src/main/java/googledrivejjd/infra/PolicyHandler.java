package googledrivejjd.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import googledrivejjd.config.kafka.KafkaProcessor;
import googledrivejjd.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    VideoProcessRepository videoProcessRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileIndexed'"
    )
    public void wheneverFileIndexed_ProcessVideoStraming(
        @Payload FileIndexed fileIndexed
    ) {
        FileIndexed event = fileIndexed;
        System.out.println(
            "\n\n##### listener ProcessVideoStraming : " + fileIndexed + "\n\n"
        );

        // Sample Logic //
        VideoProcess.processVideoStraming(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VideoUploaded'"
    )
    public void wheneverVideoUploaded_ProcessVideoStraming(
        @Payload VideoUploaded videoUploaded
    ) {
        VideoUploaded event = videoUploaded;
        System.out.println(
            "\n\n##### listener ProcessVideoStraming : " +
            videoUploaded +
            "\n\n"
        );

        // Sample Logic //
        VideoProcess.processVideoStraming(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
