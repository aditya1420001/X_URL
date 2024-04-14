package com.crio.shorturl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class XUrlImpl implements XUrl{

    private Map<String, String> longToShort;
    private Map<String, String> shortToLong;
    private Map<String, Integer> longCount;
 
    private final ShortUrlGenerator shortUrlGenerator;

    public XUrlImpl() {
        this.longToShort = new HashMap<>();
        this.shortToLong = new HashMap<>();
        this.longCount = new HashMap<>();
        this.shortUrlGenerator = new ShortUrlGenerator();
    }

    @Override
    public String registerNewUrl(String longUrl) {
        String shortUrl = longToShort.getOrDefault(longUrl, null);
        if (Objects.isNull(shortUrl)) {
            shortUrl = this.generateShortUrl();
            this.registerNewUrl(longUrl, shortUrl);
        }
        return shortUrl;
    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl) {
        if (Objects.nonNull(shortToLong.getOrDefault(shortUrl, null))) {
            return null;
        }
        this.mapShortAndLongUrls(longUrl, shortUrl);
        return shortUrl;
    }

    @Override
    public String getUrl(String shortUrl) {
        final String longUrl = shortToLong.getOrDefault(shortUrl, null);
        if (Objects.nonNull(longUrl)) {
            longCount.put(longUrl, longCount.getOrDefault(longUrl, 0)+1);
        }
        return longUrl;
    }

    @Override
    public Integer getHitCount(String longUrl) {
        return longCount.getOrDefault(longUrl, 0);
    }

    @Override
    public void delete(String longUrl) {
        shortToLong.remove(longToShort.remove(longUrl));
    }

    private String generateShortUrl() {
        return this.shortUrlGenerator.generateShortenedUrl();
    }

    /** This will take care of mapping b/w url's */
    private void mapShortAndLongUrls(String longUrl, String shortUrl) {
        this.longToShort.put(longUrl, shortUrl);
        this.shortToLong.put(shortUrl, longUrl);
    }

}