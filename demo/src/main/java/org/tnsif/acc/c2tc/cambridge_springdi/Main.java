package org.tnsif.acc.c2tc.cambridge_springdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("cambridge-springdi-Beans.xml");
		Car car = (Car) c.getBean("car");
		car.drive();
	}
}
