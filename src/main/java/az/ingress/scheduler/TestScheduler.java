package az.ingress.scheduler;

import az.ingress.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class TestScheduler {
    TestService testService;

    @Scheduled(fixedDelayString = "PT1M")
    @SchedulerLock(name = "fixed", lockAtLeastFor = "PT1M", lockAtMostFor = "PT5M")
    public void fixed() {
        testService.fixed();
    }

    //second minute hour dayOfMonth month dayOfWeek
    @Scheduled(cron = "0 17 21 * * *")
    @SchedulerLock(name = "cron", lockAtLeastFor = "PT1M", lockAtMostFor = "PT5M")
    public void cron() {
        testService.cron();
    }
}
