package org.tnsif.acc.c2tc.springioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Mobile {
	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("Beans.xml");
        Jio a=(Jio)c.getBean("jio");
        a.calling();
        a.browsing();
	}
}
