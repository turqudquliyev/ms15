package az.ingress.controller;

import az.ingress.dto.CourseDto;
import az.ingress.service.ICourseService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CourseController {
    ICourseService service;

    @GetMapping("{id}")
    public CourseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public Page<CourseDto> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @PostMapping
    public CourseDto save(@RequestBody CourseDto courseDto) {
        return service.save(courseDto);
    }
}
