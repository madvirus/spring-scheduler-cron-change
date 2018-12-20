package demo;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;

@Service
public class SchedulerService {
    private TaskScheduler scheduler;
    private String cron = "*/2 * * * * *";
    private ScheduledFuture<?> future;

    public SchedulerService(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void start() {
        ScheduledFuture<?> future = this.scheduler.schedule(() -> {
                    System.out.println("run at " + LocalDateTime.now());
                },
                new CronTrigger(cron));
        this.future = future;
    }

    public void changeCron(String cron) {
        future.cancel(true);
        this.future = null;
        this.cron = cron;
        this.start();
    }
}
