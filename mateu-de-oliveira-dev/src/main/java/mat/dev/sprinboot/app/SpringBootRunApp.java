package mat.dev.sprinboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "mat.dev.sprinboot.*")
public class SpringBootRunApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunApp.class, args);
	}

}
