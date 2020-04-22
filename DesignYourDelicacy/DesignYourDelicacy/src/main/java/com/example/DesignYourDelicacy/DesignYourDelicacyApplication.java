package com.example.DesignYourDelicacy;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@EnableFeignClients
@EnableEurekaClient
@RibbonClient(name="server", configuration = RibbonConfiguration.class)
public class DesignYourDelicacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignYourDelicacyApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).build();
	}
	@Autowired
	private Job job;
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Scheduled(fixedDelay = 8888)
	public void performJob() {
		JobParameters parameters=new JobParametersBuilder()
				.addString("JobId", String.valueOf(System.currentTimeMillis()))
				.addString("JobName", job.getName())
				.toJobParameters();
		
		try 
		{
			JobExecution execution = jobLauncher.run(job, parameters);
			if(BatchStatus.COMPLETED.equals(execution.getStatus()))
			{
				execution.stop();
			}
		}
		catch (JobExecutionAlreadyRunningException |JobRestartException|JobInstanceAlreadyCompleteException|JobParametersInvalidException e) {
			e.printStackTrace();
		}
	
	}
	
}
