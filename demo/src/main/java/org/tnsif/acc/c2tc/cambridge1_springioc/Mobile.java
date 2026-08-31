package org.tnsif.acc.c2tc.cambridge1_springioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Mobile {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("Beans.xml");
        Sim sim = c.getBean("sim", Sim.class);
        sim.calling();
        sim.browsing();
    }
}
