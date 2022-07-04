package com.example.demo.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepositery repositery){
        return args -> {
     Student gurpreet=  new Student("gurpreet","abc@gmail.com","22-12-1987",30);
     Student roshan=  new Student("roshan","abc@gmail.com","22-12-1987",25);
     System.out.println(List.of(gurpreet,roshan));
            repositery.saveAll(List.of(gurpreet,roshan));

        };
    }
}
