package ch.springframework.sfgdi;

import ch.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
//		for(String ac : ctx.getBeanDefinitionNames() ) {
//			System.out.println(ac);
//		}



		MyController myController = (MyController) ctx.getBean("myController");

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println("------- I18nController");
		System.out.println(i18nController.sayGreeting());


		System.out.println("------ MyController");
		System.out.println(myController.sayGreeting());

		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController =(PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreting());

		System.out.println("------ Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("---- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());
	}

}
