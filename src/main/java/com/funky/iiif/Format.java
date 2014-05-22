package com.funky.iiif;


import java.security.InvalidParameterException;

public enum Format {

    JPG("jpg", "image/jpg"),
    TIF("tif", "image/tiff"),
    PNG("png", "image/png"),
    GIF("gif", "image/gif"),
    JP2("jp2", "image/jp2"),
    PDF("pdf", "application/pdf");

    private final String regex;
    private final String MIMEType;

    private Format(String regex, String MIMEType) {
        this.regex = regex;
        this.MIMEType = MIMEType;
    }

    public String getMIMEType() {
        return MIMEType;
    }

    public String getString() {
        return regex;
    }

    public static Format fromString(String value) {
        for (Format f : Format.values()) {
            if (value.equals(f.regex)) {
                return f;
            }
        }
        throw new InvalidParameterException("[" + value + "] is not a valid IIIF image format.");
    }
}
