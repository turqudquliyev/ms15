package az.ingress.service;

import az.ingress.dto.request.StudentRequest;
import az.ingress.dto.response.StudentResponse;

public interface IStudentService {
    StudentResponse getById(Long id);

    StudentResponse saveStudent(StudentRequest request);
}
