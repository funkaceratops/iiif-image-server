package com.funky.iiif;

import java.security.InvalidParameterException;

public enum Quality {

    /**
     * Return the original image.
     */
    NATIVE("native"),
    /**
     * Return the original image in full color, usually using 24 bits per pixel.
     */
    COLOR("color"),
    /**
     * Return the original image in greyscale, typically using 8 bits per pixel.
     */
    GREY("grey"),
    /**
     * Return the original image with each pixel either black or white using 1 bit per pixel, when permitted.
     */
    BITONAL("bitonal");

    private final String regex;
    
    private Quality(String regex) {
        this.regex = regex;
    }

    public String getString() {
        return regex;
    }

    public static Quality fromString(String value) {
        for (Quality q : Quality.values()) {
            if (value.equals(q.regex)) {
                return q;
            }
        }
        throw new InvalidParameterException("[" + value + "] is not a valid IIIF quality.");
    }
}
