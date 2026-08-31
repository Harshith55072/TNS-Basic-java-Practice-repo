package org.tnsif.acc.c2tc.cambridge1_springioc;

public class Jio implements Sim {
    @Override
    public void calling() {
        System.out.println("Calling using Jio network");
    }

    @Override
    public void browsing() {
        System.out.println("Browsing using Jio network");
    }
}
