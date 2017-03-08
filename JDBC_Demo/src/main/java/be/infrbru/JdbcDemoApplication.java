package be.infrbru;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import be.infrbru.config.AppConfig;
import be.infrbru.service.MyService;

public class JdbcDemoApplication {

	public static void main(String[] args) {
		// THIS ANNOTATIONCONFIG CONTAINS ALL THE DECLARED BEANS
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		// YOU CAN GET THE INSTANTIATED BEANS WITH .getBean()
		MyService myService = ctx.getBean(MyService.class);
		myService.doStuff();
	}
}
