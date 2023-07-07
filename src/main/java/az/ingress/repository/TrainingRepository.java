package az.ingress.repository;

import az.ingress.domain.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long>,
        PagingAndSortingRepository<Training, Long> {
}
