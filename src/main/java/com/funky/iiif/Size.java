package com.funky.iiif;


import java.security.InvalidParameterException;

public enum Size {

    /**
     * The returned image is the same dimensions as the original image.
     */
    FULL("full"),
    /**
     * The returned image has the width specified, but maintains its aspect ratio.
     */
    WIDTH_ONLY("[\\d]+,"),
    /**
     * The returned image has the specified height, but maintains its aspect ratio.
     */
    HEIGHT_ONLY(",[\\d]+"),
    /**
     * The returned image has dimensions equal to a percentage of the original dimensions. This preserves its
     * aspect ratio.
     */
    PERCENT("pct:[\\d]+"),
    /**
     * The returned image must have both the specified width and height. This may not preserve the aspect ratio of
     * the original image.
     */
    WIDTH_AND_HEIGHT("[\\d]+,[\\d]+"),
    /**
     * The image is scaled such that the returned image has either its width or height set to the specified values
     * while also maintaining the original aspect ratio.
     */
    BEST_FIT("!" + WIDTH_AND_HEIGHT);

    private final String regex;

    private Size(String regex) {
        this.regex = regex;
    }

    public String getString() {
        return regex;
    }

    public static Size fromString(String value) {
        for (Size s : Size.values()) {
            if (value.matches(s.regex)) {
                return s;
            }
        }
        throw new InvalidParameterException("[" + value + "] is not a valid IIIF size parameter.");
    }
}
