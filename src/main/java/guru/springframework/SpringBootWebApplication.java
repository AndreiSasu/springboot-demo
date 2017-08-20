package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import guru.springframework.services.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(guru.springframework.services.storage.StorageProperties.class)
public class SpringBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
