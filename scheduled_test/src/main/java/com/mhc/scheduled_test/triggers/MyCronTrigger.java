package com.mhc.scheduled_test.triggers;

import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.TimeZone;

public class MyCronTrigger extends CronTrigger {

    public MyCronTrigger(String expression) {
        super(expression);
    }

    public MyCronTrigger(String expression, TimeZone timeZone) {
        super(expression, timeZone);
    }

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        Date next = super.nextExecutionTime(triggerContext);
        System.out.println("next time is: " + next.toString());
        return next;
    }
}
