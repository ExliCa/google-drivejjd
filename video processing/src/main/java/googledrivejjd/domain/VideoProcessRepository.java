package googledrivejjd.domain;

import googledrivejjd.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "videoProcesses",
    path = "videoProcesses"
)
public interface VideoProcessRepository
    extends PagingAndSortingRepository<VideoProcess, Long> {}
