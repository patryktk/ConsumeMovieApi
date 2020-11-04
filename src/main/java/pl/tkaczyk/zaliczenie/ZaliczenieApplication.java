package pl.tkaczyk.zaliczenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ZaliczenieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZaliczenieApplication.class, args);
    }

}
