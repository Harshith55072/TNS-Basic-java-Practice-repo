package org.tnsif.acc.c2tc.cambridge1_springioc;

public class Airtel implements Sim {
    @Override
    public void calling() {
        System.out.println("Calling using Airtel network");
    }

    @Override
    public void browsing() {
        System.out.println("Browsing using Airtel network");
    }
}
