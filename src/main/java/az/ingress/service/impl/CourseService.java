package az.ingress.service.impl;

import az.ingress.domain.Course;
import az.ingress.dto.CourseDto;
import az.ingress.exception.NotFoundException;
import az.ingress.mapper.CourseMapper;
import az.ingress.repository.CourseRepository;
import az.ingress.service.ICourseService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static az.ingress.exception.constants.ErrorMessage.COURSE_NOT_FOUND;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CourseService implements ICourseService {
    CourseRepository repository;
    CourseMapper mapper;

    @Override
    public CourseDto getById(Long id) {
        return mapper.entityToDto(fetchIfExists(id));
    }

    @Override
    public Page<CourseDto> getAll(Pageable pageable) {
        Page<Course> courses = repository.findAll(pageable);
        return courses.map(mapper::entityToDto);
    }

    @Override
    public CourseDto save(CourseDto courseDto) {
        Course savedCourse = repository.save(mapper.dtoToEntity(courseDto));
        return mapper.entityToDto(savedCourse);
    }

    public Course fetchIfExists(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(COURSE_NOT_FOUND));
    }
}
