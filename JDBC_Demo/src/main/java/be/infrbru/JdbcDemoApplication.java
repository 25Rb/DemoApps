package be.infrbru;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import be.infrbru.config.AppConfig;
import be.infrbru.model.Employer;
import be.infrbru.service.MyServiceImpl;

public class JdbcDemoApplication {

	private static final Logger LOGGER = Logger.getLogger(JdbcDemoApplication.class);

	public static void main(String[] args) {
		// THIS ANNOTATIONCONFIG CONTAINS ALL THE DECLARED BEANS
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		// YOU CAN GET THE INSTANTIATED BEANS WITH .getBean()
		MyServiceImpl myService = ctx.getBean(MyServiceImpl.class);

		LOGGER.info("\n\nSERVICE IS READY FOR USE\n------------------------\n");

		LOGGER.info("\n\n10 first EMPLOYEES\n------------------");
		for (Employer e : myService.selectAllEmployers()) {
			LOGGER.info(e.getName());
		}

		LOGGER.info("\n\nEMPLOYER WITH WGR-NR: 15215\n---------------------------\n");
		LOGGER.info(myService.selectEmployerById("15215"));
	}
}
