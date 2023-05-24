package az.ingress.converter.controller;
import az.ingress.converter.dto.Base64Dto;
import az.ingress.converter.service.ConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/converter")
@RequiredArgsConstructor
public class ConverterController {
    private final ConverterService converterService;
    @PostMapping("/to/pdf")
    public ResponseEntity<Resource> convertToPdf(@RequestBody Base64Dto base64Dto) {
        return converterService.convertToPdf(base64Dto);
    }
}