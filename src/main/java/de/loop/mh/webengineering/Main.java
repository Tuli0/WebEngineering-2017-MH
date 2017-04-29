/**
 * Created by Matthias on 29.04.2017.
 */
package de.loop.mh.webengineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping("/")
    public String index()
    {
        return new Date().toString();
    }
}