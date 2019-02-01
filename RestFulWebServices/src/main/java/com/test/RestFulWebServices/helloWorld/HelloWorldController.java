package com.test.RestFulWebServices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/hello")
	public String HelloWorld() {
		return "Hello World";
	}

	@GetMapping(path="/helloworldbean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("helloWorld");
	}
	
	@GetMapping(path="/helloworld/path-variable/{name}")
	public HelloWorldBean getHellowWorldPathVariable(@PathVariable String name)  {
		
		return new HelloWorldBean(String.format("Hello world %s", name));
		
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false)Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
}
