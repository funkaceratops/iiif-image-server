package com.funky.iiif.dto;

import com.github.jsonldjava.utils.JsonUtils;
import lombok.Data;

@Data
public class ImageInfoDto {

    // Required fields
    private String id;
    private String width;
    private String height;

    // Optional fields
    private String scale_factors;
    private String tile_width;
    private String tile_height;
    private String formats;
    private String qualities;
    private String profile;

}
