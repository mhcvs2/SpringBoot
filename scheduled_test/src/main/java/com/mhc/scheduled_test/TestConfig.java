package com.mhc.scheduled_test;

import com.mhc.scheduled_test.triggers.MyCronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;

@Configuration
public class TestConfig implements SchedulingConfigurer {

    @Autowired
    ScheduleConfig scheduleConfig;

//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addTriggerTask(
//                //1.添加任务内容(Runnable)
//                () -> System.out.println("执行定时任务2: " + LocalDateTime.now().toLocalTime()),
//                //2.设置执行周期(Trigger)
//                triggerContext -> {
//                    //2.1 从数据库获取执行周期
//                    String cron = scheduleConfig.getCron();
//                    //2.2 合法性校验.
//                    if (StringUtils.isEmpty(cron)) {
//                        // Omitted Code ..
//                    }
//                    //2.3 返回执行周期(Date)
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                }
//        );
//    }

//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        TestTask1 task1 = new TestTask1("task1");
//        scheduledTaskRegistrar.addTriggerTask(
//                task1,
//                triggerContext -> new CronTrigger(scheduleConfig.getCron()).nextExecutionTime(triggerContext)
//        );
//        TestTask1 task2 = new TestTask1("task2");
//        scheduledTaskRegistrar.addTriggerTask(
//                task2,
//                triggerContext -> new CronTrigger(scheduleConfig.getCron()).nextExecutionTime(triggerContext)
//        );
//    }

//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        TestTask1 task1 = new TestTask1("task1");
//        scheduledTaskRegistrar.addTriggerTask(
//                task1,
//                triggerContext -> {
//                    Date next = new CronTrigger(scheduleConfig.getCron()).nextExecutionTime(triggerContext);
//                    System.out.println(next.toString());
//                    return next;
//                }
//        );
//    }

//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        TestTask1 task1 = new TestTask1("task1");
//        scheduledTaskRegistrar.addTriggerTask(
//                task1,
//                new CronTrigger(scheduleConfig.getCron())
//        );
//    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        TestTask1 task1 = new TestTask1("task1");
        scheduledTaskRegistrar.addTriggerTask(
                task1,
                new MyCronTrigger(scheduleConfig.getCron())
        );
    }

}
