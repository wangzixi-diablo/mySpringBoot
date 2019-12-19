package com.sap.prolikeService;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class PromoLikeApplication extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PromoLikeApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(PromoLikeApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
	
	@Bean
    public Connector httpConnector(){
        Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(5030);
        connector.setSecure(false);
        connector.setRedirectPort(5031);
        return connector;
    }

	@Bean
	   public EmbeddedServletContainerFactory servletContainerFactory(){
	      TomcatEmbeddedServletContainerFactory containerFactory = new TomcatEmbeddedServletContainerFactory(){

	         @Override
	         protected void postProcessContext(Context context) {
	            super.postProcessContext(context);
	            SecurityConstraint constraint = new SecurityConstraint();
	            constraint.setUserConstraint("CONFIDENTIAL");
	            SecurityCollection collection = new SecurityCollection();
	            collection.addPattern("/*");
	            constraint.addCollection(collection);
	            context.addConstraint(constraint);
	         }
	      };
	      containerFactory.addAdditionalTomcatConnectors(httpConnector());
	      return containerFactory;
	   }
}
