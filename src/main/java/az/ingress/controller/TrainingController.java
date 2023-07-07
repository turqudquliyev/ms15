package az.ingress.controller;

import az.ingress.dto.TrainingDto;
import az.ingress.service.ITrainingService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/trainings")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class TrainingController {
    ITrainingService service;

    @GetMapping("{id}")
    public TrainingDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public Page<TrainingDto> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @PostMapping
    public TrainingDto save(@RequestBody TrainingDto trainingDto) {
        return service.save(trainingDto);
    }
}
