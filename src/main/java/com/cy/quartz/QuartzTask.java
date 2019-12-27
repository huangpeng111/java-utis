package com.cy.quartz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class QuartzTask extends QuartzJobBean{
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		Logger log = Logger.getLogger("ll");
		log.info("任务开始");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		System.out.println(sdf.format(Calendar.getInstance().getTime()));
		log.info("任务结束");
		
	}

}
