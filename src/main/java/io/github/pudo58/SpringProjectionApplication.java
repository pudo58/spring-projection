package io.github.pudo58;

import io.github.pudo58.entity.Champion;
import io.github.pudo58.repo.ChampionRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class SpringProjectionApplication {
    @Bean
    CommandLineRunner seedChampions(ChampionRepo championRepository) {
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Champion c1 = new Champion();
            c1.setName("Garen");
            c1.setGender("Male");
            c1.setRace("Demacian");
            c1.setDateOfBirth(sdf.parse("1990-03-01"));

            Champion c2 = new Champion();
            c2.setName("Lux");
            c2.setGender("Female");
            c2.setRace("Demacian");
            c2.setDateOfBirth(sdf.parse("1995-07-12"));

            Champion c3 = new Champion();
            c3.setName("Zed");
            c3.setGender("Male");
            c3.setRace("Ionian");
            c3.setDateOfBirth(sdf.parse("1988-11-03"));

            championRepository.saveAll(Arrays.asList(c1, c2, c3));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringProjectionApplication.class, args);
    }

}
