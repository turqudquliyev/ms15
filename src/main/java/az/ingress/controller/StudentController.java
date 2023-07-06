package az.ingress.controller;

import az.ingress.dto.request.StudentRequest;
import az.ingress.dto.response.StudentResponse;
import az.ingress.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class StudentController {
    IStudentService service;

    @GetMapping("{id}")
    public StudentResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public StudentResponse saveStudent(@RequestBody StudentRequest request) {
        return service.saveStudent(request);
    }
}
