package com.marciofm.hrapigatewayspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HrApiGatewaySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewaySpringApplication.class, args);
	}

}
