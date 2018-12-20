package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulerServiceTest {
    @Autowired
    private SchedulerService schedulerService;

    @Test
    public void changeCron() throws InterruptedException {
        schedulerService.start();
        Thread.sleep(10000);
        schedulerService.changeCron("*/3 * * * * *");
        Thread.sleep(20000);
    }
}