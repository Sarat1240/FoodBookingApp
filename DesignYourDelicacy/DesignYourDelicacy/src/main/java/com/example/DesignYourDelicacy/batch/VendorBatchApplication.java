package com.example.DesignYourDelicacy.batch;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.DesignYourDelicacy.entity.VendorMenu;



@Configuration
@EnableBatchProcessing
public class VendorBatchApplication {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	@Autowired
	public EntityManagerFactory entityManagerFactory;
	
	
	/*
	 * @Value("/DesignYourDelicacy/src/main/resources/input/vendor*.csv") private
	 * Resource[] inputResources;
	 * 
	 * @Bean public MultiResourceItemReader<VendorMenu> multiResourceItemReader() {
	 * MultiResourceItemReader<VendorMenu> resourceItemReader = new
	 * MultiResourceItemReader<VendorMenu>();
	 * resourceItemReader.setResources(inputResources);
	 * resourceItemReader.setDelegate(reader()); return resourceItemReader; }
	 */
	 
	@Bean
	public FlatFileItemReader<VendorMenu> reader() {
		FlatFileItemReader<VendorMenu> reader = new FlatFileItemReader<VendorMenu>();
		reader.setResource(new ClassPathResource("vendor1.csv"));
		reader.setLineMapper(new DefaultLineMapper<VendorMenu>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "vendor_id","vendor_name","serial_num", "item_name", "item_desc", "price"});
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<VendorMenu>() {
					{
						setTargetType(VendorMenu.class);
					}
				});

			}
		});
		reader.setLinesToSkip(1);

		return reader;
	}

	@Bean
	public JdbcBatchItemWriter<VendorMenu> writer() {
		JdbcBatchItemWriter<VendorMenu> writer = new JdbcBatchItemWriter<VendorMenu>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<VendorMenu>());
		writer.setSql(
				"INSERT INTO vendor_menu(vendor_id,vendor_name,serial_num,item_name,item_desc,price) VALUES (:vendorId,:vendorName,:serialNum,:itemName,:itemDesc,:price)");
		writer.setDataSource(dataSource);

		return writer;
	}

	@Bean
	public JpaItemWriter<VendorMenu> jpaWriter() {
		JpaItemWriter<VendorMenu> jpaWriter = new JpaItemWriter<VendorMenu>();
		jpaWriter.setEntityManagerFactory(entityManagerFactory);
		return jpaWriter;
	}
	
	@Bean
	public Job readVendorMenuCSVFile() {
		return jobBuilderFactory.get("Job1").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<VendorMenu, VendorMenu>chunk(1).reader(reader()).writer(writer()).build();
	}
	
}
