package com.funky.iiif;


import java.security.InvalidParameterException;

public enum Region {

    /**
     * Complete image.
     */
    FULL("full"),
    /**
     * Region of the image specified by the top left point and a width and height: x, y, w, h in pixels. Integers
     * only.
     */
    ABSOLUTE_DIMENSIONS("[\\d]+,[\\d]+,[\\d]+,[\\d]+"),
    /**
     * Region of the image specified by the top left point and a width and height as a percentage of the original
     * image: x, y, w, h (as percent of total width/total height). Decimal numbers are allowed.
     */
    PERCENT_DIMENSINOS("pct:" + "[\\d]*\\.?[\\d*]");

    private final String region;

    private Region(String region) {
        this.region = region;
    }

    public String getString() {
        return region;
    }

    public static Region getRegionFromString(String region) {
        for (Region r : Region.values()) {
            if (region.matches(r.region)) {
                return r;
            }
        }
        throw new InvalidParameterException("[" + region + "] is not a valid IIIF Region.");
    }
}
