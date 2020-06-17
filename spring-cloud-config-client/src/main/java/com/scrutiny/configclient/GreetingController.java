package com.scrutiny.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
@RefreshScope
public class GreetingController {
	@Value("${my.greeting.message:Hello}")
	String greetingMessage;
	
	@RequestMapping("/greetMe")
	public String greetMe() {
		return greetingMessage;
	}
}
