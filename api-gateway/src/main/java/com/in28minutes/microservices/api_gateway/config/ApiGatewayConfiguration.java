package com.in28minutes.microservices.api_gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
		return builder.routes()
//				.route(p->p.path("/get")
//								.filters(f->f
//										.addRequestHeader("MyHeader","My")
//										.addRequestParameter("Param","Value"))
//								.uri("http://httpbin.org.80"))
				.route(p->p.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))
				.route(p->p.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion-new/**")
						.filters(f->f.rewritePath(
								"/currency-conversion-new/(?<segment>.*)",
								"/currency-conversion-feign/${segment}"
						))
						.uri("lb://currency-conversion"))
				.build();
		
		/*
		Hence by this we can modify our route
		here we have /currency-exchange/**  and we have now called
		currency-exchange from eureka along with saying lb -> loadBalancing as there can be multiple
		instances running
		 */
		
		/*
			 This filter rewrites incoming requests that start with /currency-conversion-new/
			 It captures the rest of the path (everything after /currency-conversion-new/) into a named group "segment"
             Then it rewrites the path to /currency-conversion-feign/<captured-segment>
			 Example: /currency-conversion-new/100/USD -> /currency-conversion-feign/100/USD
             This allows routing requests to the same service but with a modified path,
			 which is useful for versioning or routing via Feign.
		*/
	}
}
