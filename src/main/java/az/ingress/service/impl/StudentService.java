package az.ingress.service.impl;

import az.ingress.domain.Student;
import az.ingress.domain.StudentDetail;
import az.ingress.dto.request.StudentRequest;
import az.ingress.dto.response.StudentResponse;
import az.ingress.exception.NotFoundException;
import az.ingress.repository.StudentRepository;
import az.ingress.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static az.ingress.exception.constants.ErrorMessage.STUDENT_NOT_FOUND;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class StudentService implements IStudentService {
    StudentRepository repository;

    @Override
    public StudentResponse getById(Long id) {
        return buildStudentResponse(fetchIfExists(id));
    }

    @Override
    public StudentResponse saveStudent(StudentRequest request) {
        return buildStudentResponse(repository.save(buildStudent(request)));
    }


    private StudentResponse buildStudentResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .address(student.getStudentDetail().getAddress())
                .age(student.getStudentDetail().getAge())
                .email(student.getStudentDetail().getEmail())
                .build();
    }

    private Student buildStudent(StudentRequest request) {
        StudentDetail studentDetail = StudentDetail.builder()
                .age(request.getAge())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();
        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .studentDetail(studentDetail)
                .build();
        studentDetail.setStudent(student);
        return student;
    }

    private Student fetchIfExists(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(STUDENT_NOT_FOUND));
    }
}

