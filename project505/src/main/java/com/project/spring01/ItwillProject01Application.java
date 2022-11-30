package com.project.spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA의 AuditingEntityListener 기능을 활성화하기 위해서.
public class ItwillProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(ItwillProject01Application.class, args);
	}

}
