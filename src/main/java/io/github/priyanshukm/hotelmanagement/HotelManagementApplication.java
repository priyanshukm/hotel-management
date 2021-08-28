package io.github.priyanshukm.hotelmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelManagementApplication {

	// Please override the run method below to initialize some data in your repository
	// We might want to add some fixture reading code to populate the repository on app startup
	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplication.class, args);
	}

}
