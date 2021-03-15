package de.zoo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Job {
//    @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "*/3 * * * * *")
    public void job(){
        System.out.println(LocalDateTime.now());
    }
}
