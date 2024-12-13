package io.runner.runner;

//import io.runner.runner.WelcomeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import run.Location;
import run.Run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
//import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RunnerApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerApplication.class, args);
		log.info("Application Started Successfully");
		log.info("Something Changed");
//		ConfigurableApplicationContext context =  SpringApplication.run(RunnerApplication.class, args);

//		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean('WelcomeMessage');
//		System.out.println(welcomeMessage);
//		var welcomeMessage = new WelcomeMessage();
//		System.out.println(welcomeMessage.getWelcomeMeggase());
	}

	// Commandline runner is something that runs after the application has been created
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
			log.info("Run" + run);
		};
	}

}
