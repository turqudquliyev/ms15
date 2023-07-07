package az.ingress.service;

import az.ingress.dto.TrainingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITrainingService {
    TrainingDto getById(Long id);

    Page<TrainingDto> getAll(Pageable pageable);

    TrainingDto save(TrainingDto trainingDto);
}
