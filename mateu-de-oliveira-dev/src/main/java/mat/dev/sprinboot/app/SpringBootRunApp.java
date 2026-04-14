package mat.dev.sprinboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "mat.dev.sprinboot.*")
@EntityScan(basePackages = "mat.dev.sprinboot.entidades")
@EnableJpaRepositories(basePackages = "mat.dev.sprinboot.repository")
@ComponentScan(basePackages = "mat.dev.sprinboot.*")
public class SpringBootRunApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunApp.class, args);
	}

}
