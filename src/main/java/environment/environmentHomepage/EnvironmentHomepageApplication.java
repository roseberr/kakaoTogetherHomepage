package environment.environmentHomepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EnvironmentHomepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvironmentHomepageApplication.class, args);
	}

}
