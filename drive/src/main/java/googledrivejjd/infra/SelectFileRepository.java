package googledrivejjd.infra;

import googledrivejjd.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "selectFiles",
    path = "selectFiles"
)
public interface SelectFileRepository
    extends PagingAndSortingRepository<SelectFile, Long> {}
