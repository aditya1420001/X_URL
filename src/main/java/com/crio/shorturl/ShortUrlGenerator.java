package com.crio.shorturl;

public class ShortUrlGenerator {

    private final AlphaNumericStringGenerator alphaNumbericStringGenerator;

    private static final String SHORT_URL_BASE_STRING = "http://short.url/";


    public ShortUrlGenerator() {
        this.alphaNumbericStringGenerator = new AlphaNumericStringGenerator();
    }

    public String generateShortenedUrl () {
        final String alphaNumericString = this.alphaNumbericStringGenerator.generateAlphaNumbericString();
        return SHORT_URL_BASE_STRING.concat(alphaNumericString);
    }



}
