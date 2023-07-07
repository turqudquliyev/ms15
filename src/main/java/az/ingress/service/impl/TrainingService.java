package az.ingress.service.impl;

import az.ingress.domain.Course;
import az.ingress.domain.Training;
import az.ingress.dto.TrainingDto;
import az.ingress.exception.NotFoundException;
import az.ingress.repository.TrainingRepository;
import az.ingress.service.ICourseService;
import az.ingress.service.ITrainingService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static az.ingress.exception.constants.ErrorMessage.TRAINING_NOT_FOUND;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class TrainingService implements ITrainingService {
    TrainingRepository repository;
    ICourseService courseService;

    @Override
    public TrainingDto getById(Long id) {
        Training training = repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(TRAINING_NOT_FOUND));
        return getBuild(training);
    }

    @Override
    public Page<TrainingDto> getAll(Pageable pageable) {
        Page<Training> trainings = repository.findAll(pageable);
        return trainings.map(this::getBuild);
    }

    @Override
    public TrainingDto save(TrainingDto trainingDto) {
        Course course = courseService.fetchIfExists(trainingDto.getCourseId());
        Training training = getTraining(trainingDto, course);
        Training savedTraining = repository.save(training);
        return getBuild(savedTraining);
    }

    private Training getTraining(TrainingDto trainingDto, Course course) {
        return Training.builder()
                .name(trainingDto.getName())
                .price(trainingDto.getPrice())
                .course(course).build();
    }

    private TrainingDto getBuild(Training savedTraining) {
        return TrainingDto.builder()
                .name(savedTraining.getName())
                .price(savedTraining.getPrice())
                .courseId(savedTraining.getCourse().getId())
                .build();
    }
}
