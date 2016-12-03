package com.simpleService.resource;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.common.base.Optional;
import com.simpleService.domain.Domain;
import com.yammer.metrics.annotation.Timed;
import javax.ws.rs.core.MediaType;


@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Domain sayHello(@QueryParam("name") Optional<String> name) {
        return new Domain(counter.incrementAndGet(),
                          String.format(template, name.or(defaultName)));
    }
}
