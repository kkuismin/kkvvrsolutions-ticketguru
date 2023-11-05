package kkvvsolutions.TicketGuru;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketGuruApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);

		LocalDateTime ldt = LocalDateTime.now();

		System.out.println(ldt);

	}
}