package az.ingress.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public void fixed() {
        System.out.println("Fixed");
    }

    public void cron() {
        System.out.println("Cron");
    }
}
