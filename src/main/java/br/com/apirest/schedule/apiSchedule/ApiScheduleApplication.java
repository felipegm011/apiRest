package br.com.apirest.schedule.apiSchedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class ApiScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiScheduleApplication.class, args);
	}

}
