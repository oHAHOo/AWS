package org.zerock.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsApplication.class, args);
	}

}
