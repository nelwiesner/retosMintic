package co.edu.usa.reto3.audience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.edu.usa.reto3.audience.model"})
@SpringBootApplication
public class AudienceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudienceApplication.class, args);
	}

}
