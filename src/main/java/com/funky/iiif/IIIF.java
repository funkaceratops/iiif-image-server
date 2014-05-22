package com.funky.iiif;

import java.util.HashMap;
import java.util.Map;

public interface IIIF {

    public interface Region {
        /**
         * Complete image.
         */
        String FULL = "full";
        /**
         * Region of the image specified by the top left point and a width and height: x, y, w, h in pixels. Integers
         * only.
         */
        String ABSOLUTE_DIMENSIONS = "[\\d]+,[\\d]+,[\\d]+,[\\d]+";
        /**
         * Region of the image specified by the top left point and a width and height as a percentage of the original
         * image: x, y, w, h (as percent of total width/total height). Decimal numbers are allowed.
         */
        String PERCENT_DIMENSINOS = "pct:" + "[\\d]*\\.?[\\d*]";
    }

    public interface Size {
        /**
         * The returned image is the same dimensions as the original image.
         */
        String FULL = "full";
        /**
         * The returned image has the width specified, but maintains its aspect ratio.
         */
        String WIDTH_ONLY = "[\\d]+,";
        /**
         * The returned image has the specified height, but maintains its aspect ratio.
         */
        String HEIGHT_ONLY = ",[\\d]+";
        /**
         * The returned image has dimensions equal to a percentage of the original dimensions. This preserves its
         * aspect ratio.
         */
        String PERCENT = "pct:[\\d]+";
        /**
         * The returned image must have both the specified width and height. This may not preserve the aspect ratio of
         * the original image.
         */
        String WIDTH_AND_HEIGHT = "[\\d]+,[\\d]+";
        /**
         * The image is scaled such that the returned image has either its width or height set to the specified values
         * while also maintaining the original aspect ratio.
         */
        String BEST_FIT = "!" + WIDTH_AND_HEIGHT;
    }

    public interface Quality {
        /**
         * Return the original image.
         */
        String NATIVE = "native";
        /**
         * Return the original image in full color, usually using 24 bits per pixel.
         */
        String COLOR = "color";
        /**
         * Return the original image in greyscale, typically using 8 bits per pixel.
         */
        String GREY = "grey";
        /**
         * Return the original image with each pixel either black or white using 1 bit per pixel, when permitted.
         */
        String BITONAL = "bitonal";
    }

    public abstract class Format {
        public static final String JPG = "jpg";
        public static final String TIF = "tif";
        public static final String PNG = "png";
        public static final String GIF = "gif";
        public static final String JP2 = "jp2";
        public static final String PDF = "pdf";

        private static final Map<String, String> formats;

        static {
            formats = new HashMap<>();

            formats.put(JPG, "image/jpeg");
            formats.put(TIF, "image/tiff");
            formats.put(PNG, "image/png");
            formats.put(GIF, "image/gif");
            formats.put(JP2, "image/jp2");
            formats.put(PDF, "application/pdf");
        }

        /**
         * Get the MIME Type of the specified image format.
         *
         * @param extension file extension of the requested format
         * @return a string representing the MIMEType
         */
        public static String getMIMEType(String extension) {
            return formats.get(extension);
        }
    }

}
