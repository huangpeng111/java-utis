package com.cy.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuzrtzConfig {
	
	//1.获取jobDetail
	@Bean
	public JobDetail job1() {
		return JobBuilder.newJob(QuartzTask.class).withIdentity("task1").storeDurably().build();
	}
	
	//触发器
	@Bean
	public Trigger trigger1() {
		return TriggerBuilder.newTrigger()
				.forJob(job1())
				.withIdentity("task1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
				.build();
	}

}
