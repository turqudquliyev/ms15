package az.ingress.mapper;

import az.ingress.domain.Course;
import az.ingress.dto.CourseDto;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface CourseMapper {
    CourseDto entityToDto(Course course);

    Course dtoToEntity(CourseDto courseDto);
}
