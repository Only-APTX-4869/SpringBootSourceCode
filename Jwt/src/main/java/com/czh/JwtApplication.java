package com.czh;

import com.czh.token.jwt.TestHS256;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class JwtApplication {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(JwtApplication.class, args);
        TestHS256.testHS256();
    }

}
