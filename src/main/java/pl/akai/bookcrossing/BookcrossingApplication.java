package pl.akai.bookcrossing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BookcrossingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookcrossingApplication.class, args);
    }

}
