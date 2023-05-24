package az.ingress.converter.service;
import az.ingress.converter.dto.Base64Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Base64;
@Service
@Slf4j
public class ConverterService {
    public ResponseEntity<Resource> convertToPdf(Base64Dto base64Dto) {
        try {
            byte[] bytes = Base64.getDecoder().decode(base64Dto.getBase64());
            ByteArrayResource resource = new ByteArrayResource(bytes);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);
        } catch (Exception ex) {
            log.info("ActionLog.ConverterService.convertToPdf base64Dto: {} exception: {}", base64Dto.getBase64(), ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}