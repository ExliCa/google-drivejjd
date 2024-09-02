package googledrivejjd.infra;

import googledrivejjd.config.kafka.KafkaProcessor;
import googledrivejjd.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1(
        @Payload FileUploaded fileUploaded
    ) {
        try {
            if (!fileUploaded.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setFileId(fileUploaded.getFileId());
            dashboard.setFileName(fileUploaded.getFileName());
            dashboard.setFileSize(fileUploaded.getFileSize());
            dashboard.setUploadYn(fileUploaded.getUploadYn());
            dashboard.setIndexYn(fileUploaded.getIndexYn());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVideoUploaded_then_CREATE_2(
        @Payload VideoUploaded videoUploaded
    ) {
        try {
            if (!videoUploaded.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setFileId(videoUploaded.getFileId());
            dashboard.setFileName(videoUploaded.getFileName());
            dashboard.setFileSize(videoUploaded.getFileSize());
            dashboard.setUploadYn(videoUploaded.getUploadYn());
            dashboard.setIndexYn(videoUploaded.getIndexYn());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileIndexed_then_UPDATE_1(
        @Payload FileIndexed fileIndexed
    ) {
        try {
            if (!fileIndexed.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByIndexId(
                fileIndexed.getIndexId()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setFileId(fileIndexed.getFileId());
                dashboard.setIndexId(fileIndexed.getIndexId());
                dashboard.setFileName(fileIndexed.getFileName());
                dashboard.setIndexYn(fileIndexed.getIndexYn());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVideoStreamed_then_UPDATE_2(
        @Payload VideoStreamed videoStreamed
    ) {
        try {
            if (!videoStreamed.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByStreamingId(
                videoStreamed.getStramingId()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setFileId(videoStreamed.getFileId());
                dashboard.setStreamingId(videoStreamed.getStramingId());
                dashboard.setFileName(videoStreamed.getFileName());
                dashboard.setStreamingUrl(videoStreamed.getStreamingUrl());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
