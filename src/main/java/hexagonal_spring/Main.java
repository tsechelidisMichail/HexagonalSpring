package hexagonal_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		DBemulation.createTest();
		SpringApplication.run(Main.class, args);
	}

}