package com.isb.chile;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import com.isb.chile.processor.FileProcessor;


@SpringBootApplication
@EnableTask
public class Application {
	
	@Autowired
	FileProcessor fileProcessor;
	
	static final Logger LOGGER = Logger.getLogger(Application.class);

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new BatchCommandLineRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public class BatchCommandLineRunner implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			try {
				
				fileProcessor.processFile(strings);
			} catch (Exception e) {
				LOGGER.error("Error en la ejecucion");
				throw e;
			}
		}
	}
}