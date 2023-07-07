package az.ingress.service;

import az.ingress.domain.Course;
import az.ingress.dto.CourseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICourseService {
    CourseDto getById(Long id);

    Page<CourseDto> getAll(Pageable pageable);

    CourseDto save(CourseDto courseDto);
    Course fetchIfExists(Long id);
}
