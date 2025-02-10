package com.msa.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RoutingConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		Function<PredicateSpec,Buildable<Route>> function
			= p -> p.path("/get").
				filters(f -> f.addRequestHeader("CustomHeader", "headerValue")
						.addRequestParameter("Customparam", "value"))
				.uri("http://httpbin.org:80");
			
			return builder.routes().route(function).build();
				
				
				
	}
}
