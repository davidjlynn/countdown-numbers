package com.davidjlynn.countdownnumbers;

import com.davidjlynn.countdownnumbers.shell.Commands;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;
import org.springframework.shell.command.annotation.EnableCommand;

@SpringBootApplication
@CommandScan
@EnableCommand(Commands.class)
public class CountdownNumbersApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountdownNumbersApplication.class, args);
    }
}
