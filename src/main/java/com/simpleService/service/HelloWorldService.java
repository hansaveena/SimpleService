package com.simpleService.service;

import com.simpleService.configuration.HelloWorldConfiguration;
import com.simpleService.configuration.TemplateHealthCheck;
import com.simpleService.resource.HelloWorldResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;

public class HelloWorldService extends Service<HelloWorldConfiguration> {
	public static void main(String[] args) throws Exception {
		new HelloWorldService().run(args);
	}

	
	private HelloWorldService() {
		super("hello-world");
	}
	
	@Override
	protected void initialize(HelloWorldConfiguration configuration, Environment environment) throws Exception {
		final String template = configuration.getTemplate();
		final String defaultName = configuration.getDefaultName();
		environment.addResource(new HelloWorldResource(template, defaultName));
		environment.addHealthCheck(new TemplateHealthCheck(template));
	}

}