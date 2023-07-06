package az.ingress.repository;

import az.ingress.domain.StudentDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailRepository extends CrudRepository<StudentDetail, Long> {
}
