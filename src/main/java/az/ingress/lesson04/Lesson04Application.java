package az.ingress.lesson04;

import az.ingress.lesson04.config.Test;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson04Application implements CommandLineRunner {
	public Lesson04Application(Test test1, Test test2, @Qualifier("ModelMapper2") ModelMapper modelMapper) {
		this.test1 = test1;
		this.test2 = test2;
		this.modelMapper = modelMapper;
	}

	private final Test test1;
	private final Test test2;
	private final ModelMapper modelMapper;

	public static void main(String[] args) {
		System.out.println("Start app  server");
		SpringApplication.run(Lesson04Application.class, args);
		System.out.println("Completed start");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Initialisation Completed");
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(modelMapper);
	}
}
