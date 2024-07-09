package ru.namazov.ebank;

import org.springframework.boot.SpringApplication;

public class TestEbankApplication {

	public static void main(String[] args) {
		SpringApplication.from(EbankApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
