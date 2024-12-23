package com.softwaretestingboard.magento;

import java.security.SecureRandom;

public final class Values {
    public static final String firstname = "John";
    public static final String lastname = "Doe";
    public static final String emailId;
    public static final String password = "Password@1234";

    static {
        SecureRandom random = new SecureRandom();

        long suffix = random.nextLong(10000000, 100000000);

        emailId = "random+" + suffix + "@example.com";
    }

    private Values() {
        throw new AssertionError("cannot instantiate class");
    }
}
