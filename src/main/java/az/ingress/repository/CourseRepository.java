package az.ingress.repository;


import az.ingress.domain.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>,
        PagingAndSortingRepository<Course, Long> {
}
