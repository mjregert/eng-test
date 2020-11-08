package fitpay.engtest;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static String bearerToken = "";
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("oAuthToken required to be passed in");
            return;
        }
        Application.bearerToken = args[0];
        SpringApplication.run(Application.class, args);
    }
}
