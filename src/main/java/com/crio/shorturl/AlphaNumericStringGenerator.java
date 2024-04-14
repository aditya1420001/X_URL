package com.crio.shorturl;

import java.util.Random;

public class AlphaNumericStringGenerator {
    private static final String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                                        + "0123456789"
                                                            + "abcdefghijklmnopqrstuvxyz";
    private static final int LENGTH = 9;
    private static final Random random = new Random();


    public String generateAlphaNumbericString() {
        
        char[] res = new char[LENGTH];

        for (int i=0; i < LENGTH; i++) {
            res[i] = alphaNumericString.charAt(random.nextInt(alphaNumericString.length()));
        }

        return new String(res);
    }
                                                        
}